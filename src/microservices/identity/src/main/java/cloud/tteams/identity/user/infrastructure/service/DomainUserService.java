package cloud.tteams.identity.user.infrastructure.service;

import cloud.tteams.identity.common.infrastructure.utils.OTPUtil;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.rules.*;
import cloud.tteams.identity.user.domain.repository.otp.IRegistrationTokenCommandRepository;
import cloud.tteams.identity.user.domain.repository.otp.IRegistrationTokenQueryRepository;
import cloud.tteams.identity.user.domain.repository.user.IUserCommandRepository;
import cloud.tteams.identity.user.domain.repository.user.IUserQueryRepository;
import cloud.tteams.identity.user.domain.service.IPasswordEncoder;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.identity.user.infrastructure.adapter.query.user.PostgresDBUserQueryRepository;
import cloud.tteams.share.core.domain.exception.DomainException;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.rules.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class DomainUserService implements IUserService {

    private final IUserCommandRepository commandRepository;
    private final IUserQueryRepository queryRepository;
    private final IPasswordEncoder passwordEncoder;
    private final IEventService<User> eventService;
    private final IRegistrationTokenCommandRepository registrationCommandRepository;
    private final IRegistrationTokenQueryRepository registrationQueryRepository;
    private final PostgresDBUserQueryRepository postgresDBUserQueryRepository;

    /**
     * REGISTRATION_TOKEN_EXPIRE configuration variable,
     * time in minutes after witch Validation Token will expire.
     *
     * <p>
     * Default: 5 minutes
     */
    @Value("${user.validation.expire:5}")
    private int REGISTRATION_TOKEN_EXPIRE;

    /**
     * REGISTRATION_TOKEN_MAX_ATTEMPTS configuration variable,
     * maximum number of attempts in the DateTime range allowed.
     * <p>
     * See {@code REGISTRATION_TOKEN_EXPIRE}
     *
     * <p>
     * Default: 3 attempts
     */
    @Value("${user.validation.attempts:3}")
    private int REGISTRATION_TOKEN_MAX_ATTEMPTS;

    @Value("${kafka.messenger.user:true}")
    private boolean messengerIsActive;

    public DomainUserService(
            IUserCommandRepository commandRepository,
            IUserQueryRepository queryRepository,
            IPasswordEncoder passwordEncoder,
            IEventService<User> eventService,
            IRegistrationTokenCommandRepository registrationCommandRepository,
            IRegistrationTokenQueryRepository registrationQueryRepository, PostgresDBUserQueryRepository postgresDBUserQueryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventService = eventService;
        this.registrationCommandRepository = registrationCommandRepository;
        this.registrationQueryRepository = registrationQueryRepository;
        this.postgresDBUserQueryRepository = postgresDBUserQueryRepository;
    }

    @Override
    public void createUser(User user) {
        RulesChecker.checkRule(new UserFirstNameRequiredRule(user.getFirstName()));
        RulesChecker.checkRule(new UserLastNameRequiredRule(user.getLastName()));
        RulesChecker.checkRule(new UserEmailRequiredRule(user.getEmail()));
        RulesChecker.checkRule(new UserEmailMustBeUniqueRule(postgresDBUserQueryRepository, user));
        RulesChecker.checkRule(new UserPasswordRequiredRule(user.getPassword()));
        RulesChecker.checkRule(new UserPasswordMustBeSecureRule(user.getPassword()));
        RulesChecker.checkRule(new UserTypeRequiredRule(user.getType()));
        if (Objects.nonNull(user.getIdentification())) {
            RulesChecker.checkRule(new UserIdentificationMustBeUniqueRule(queryRepository, user));
        }
        user.updatePassword(passwordEncoder.encode(user.getPassword()));
        this.commandRepository.create(user);
        if (messengerIsActive) {
            eventService.create(user);
        }
    }

    @Override
    public User findById(UUID id) {
        return queryRepository.findById(id);
    }


    @Override
    public MessagePaginatedResponse getPaginatedUsers(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter) {
        return queryRepository.findAll(pageable, firstName,lastName, identification, email,  type,state,  filter);
    }

    @Override
    public UUID delete(UUID id) {
        User user = this.queryRepository.findById(id);
        this.commandRepository.delete(user);
        if (messengerIsActive) {
            eventService.delete(user);
        }
        return id;
    }

    @Override
    public void updateUser(User user) {
        User toUpdate = this.queryRepository.findById(user.getId());
        RulesChecker.checkRule(new UserPasswordMustBeSecureRule(user.getPassword()));
        toUpdate.updatePassword(passwordEncoder.encode(user.getPassword()));
        if (Objects.nonNull(user.getIdentification())) {
            RulesChecker.checkRule(new UserIdentificationMustBeUniqueRule(queryRepository, user));
        }
        RulesChecker.checkRule(new UserFirstNameRequiredRule(toUpdate.getFirstName()));
        RulesChecker.checkRule(new UserLastNameRequiredRule(toUpdate.getLastName()));
        RulesChecker.checkRule(new UserEmailRequiredRule(toUpdate.getEmail()));
        RulesChecker.checkRule(new UserEmailMustBeUniqueRule(postgresDBUserQueryRepository, toUpdate));
        RulesChecker.checkRule(new UserPasswordRequiredRule(toUpdate.getPassword()));
        RulesChecker.checkRule(new UserTypeRequiredRule(toUpdate.getType()));
        commandRepository.update(toUpdate);
        if (messengerIsActive) {
            eventService.update(toUpdate);
        }
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = queryRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new DomainException("Not valid or missed identification");
        }
        return user.get();
    }

    @Override
    public Optional<RegistrationToken> registerUser(User user) {
        Optional<User> oUser = queryRepository.findByEmail(user.getEmail());
        if (oUser.isPresent()) {
            switch (oUser.get().getRegistrationState()) {
                case VERIFICATION_ACCEPTED -> throw new DomainException("User has registered before!");
                case VERIFICATION_PENDING -> throw new DomainException("User registration pending of validation!");
                case VERIFICATION_BLOCKED -> throw new DomainException("User registration blocked");
                default -> {
                    return Optional.empty();
                }
            }
        }
        else {
            user.setFreshInstallTokenState();
            createUser(user);
            LocalDateTime currenDateTime = LocalDateTime.now();
            RegistrationToken registrationToken = new RegistrationToken(UUID.randomUUID(), user, OTPUtil.genOTP(), 0, currenDateTime,
                    currenDateTime.plusMinutes(REGISTRATION_TOKEN_EXPIRE));
            registrationCommandRepository.create(registrationToken);
            return Optional.of(registrationToken);
        }
    }

    @Override
    @Transactional
    public void validateOTP(String otp, String password) {
        Optional<RegistrationToken> registrationToken = registrationQueryRepository
                .findByOtp(otp);
        if (registrationToken.isPresent()) {
            RegistrationToken token = registrationToken.get();
            LocalDateTime currentDateTime = LocalDateTime.now();
            RulesChecker.checkRule(new RegistrationTokenExpiredRule(token, currentDateTime), () -> {
                String uOtp = OTPUtil.genOTP();
                LocalDateTime uEndingDateTime = currentDateTime.plusMinutes(REGISTRATION_TOKEN_EXPIRE);
                RegistrationToken uRegistrationToken = new RegistrationToken(token.getId(), token.getUser(), uOtp,
                        0, currentDateTime, uEndingDateTime);
                registrationCommandRepository.update(uRegistrationToken);
            });
            RulesChecker.checkRule(new RegistrationTokenMaxAttemptsRule(token, REGISTRATION_TOKEN_MAX_ATTEMPTS), () -> {
                User user = token.getUser();
                user.blockUserByMaxTokenVerificationAttempts();
                commandRepository.update(user);
                if (messengerIsActive) {
                    eventService.update(user);
                }
            });
            User user = token.getUser();
            user.unBlockUserByMaxTokenVerificationAttempts();
            user.updatePassword(password);
            commandRepository.update(user);
            if (messengerIsActive) {
                eventService.update(user);
            }
        } else {
            throw new DomainException(String.format("%s is not a valid OTP!", otp));
        }
    }

    @Override
    public boolean existByEmailAndIdNot(UUID id, String email) {
        return queryRepository.existByEmailAndIdNot(id, email);
    }

    @Override
    @Transactional
    public void changePassword(String identification, String oldPassword, String newPassword) {
        User user = this.findByEmail(identification);
        RulesChecker.checkRule(new UserPasswordMatchRule(passwordEncoder, user, oldPassword));
        user.updatePassword(passwordEncoder.encode(newPassword));
        updateUser(user);
        if (messengerIsActive) {
            eventService.update(user);
        }
    }

    @Override
    @Transactional
    public void spreadUsers() {
        List<User> allUsers = commandRepository.findAll();
        allUsers.forEach(eventService::create);
    }

}
