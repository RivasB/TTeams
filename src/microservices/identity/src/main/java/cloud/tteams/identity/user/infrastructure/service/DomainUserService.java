package cloud.tteams.identity.user.infrastructure.service;

import cloud.tteams.identity.shared.infrastructure.utils.OTPUtil;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.rules.*;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenCommandRepository;
import cloud.tteams.identity.user.domain.repository.IRegistrationTokenQueryRepository;
import cloud.tteams.identity.user.domain.repository.IUserCommandRepository;
import cloud.tteams.identity.user.domain.repository.IUserQueryRepository;
import cloud.tteams.identity.user.domain.rules.*;
import cloud.tteams.identity.user.domain.service.IPasswordEncoder;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.CollectionValueObject;
import cloud.tteams.share.core.domain.DomainException;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.RulesChecker;
import cloud.tteams.share.core.domain.StringValueObject;
import cloud.tteams.share.core.domain.service.IEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional(readOnly = true)
public class DomainUserService implements IUserService {

    private final IUserCommandRepository commandRepository;
    private final IUserQueryRepository queryRepository;
    private final IPasswordEncoder passwordEncoder;
    private final IEventService<User> eventService;
    private final IRegistrationTokenCommandRepository registrationCommandRepository;
    private final IRegistrationTokenQueryRepository registrationQueryRepository;

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
            IRegistrationTokenQueryRepository registrationQueryRepository) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.passwordEncoder = passwordEncoder;
        this.eventService = eventService;
        this.registrationCommandRepository = registrationCommandRepository;
        this.registrationQueryRepository = registrationQueryRepository;
    }

    @Override
    @Transactional
    public void createUser(User user) {
        RulesChecker.checkRule(new UserFirstNameRequiredRule(user.getFirstName()));
        RulesChecker.checkRule(new UserLastNameRequiredRule(user.getLastName()));
        RulesChecker.checkRule(new UserIdentificationRequiredRule(user.getIdentification()));
        RulesChecker.checkRule(new UserIdentificationMustBeUniqueRule(this, user));
        RulesChecker.checkRule(new UserEmailRequiredRule(user.getEmail()));
        RulesChecker.checkRule(new UserEmailMustBeUniqueRule(this, user));
        RulesChecker.checkRule(new UserPasswordRequiredRule(user.getPassword()));
        RulesChecker.checkRule(new UserPasswordMustBeSecureRule(user.getPassword()));
        RulesChecker.checkRule(new UserTypeRequiredRule(user.getType()));
        RulesChecker.checkRule(new UserStateRequiredRule(user.getState()));
        RulesChecker.checkRule(new UserProfilesRequiredRule(user.getType(), user.getProfiles()));

        UserPassword cryptPassword = new UserPassword(passwordEncoder.encode(user.getPassword().value()));

        User userSave = new User(user.getId(), user.getFirstName(), user.getLastName(), user.getIdentification(),
                user.getEmail(), cryptPassword, user.getType(), user.getState(), user.getProfiles(),
                user.getRegistrationState(), user.getPhone(), user.getTelephoneOperator(),
                user.getShouldChangePassword());

        this.commandRepository.create(userSave);

        if (messengerIsActive) {
            eventService.create(userSave);
        }
    }

    @Override
    public User findById(UserId id) {
        return queryRepository.findById(id);
    }

//    @Override
//    public MessagePaginatedResponse getPaginatedUsers(Pageable pageable, String filter) {
//        if (!"".equals(filter)) {
//            return this.queryRepository.allUsersWithFilter(pageable, filter);
//        }
//
//        return this.queryRepository.allUsersWithOutFilter(pageable);
//    }


    @Override
    public MessagePaginatedResponse getPaginatedUsers(Pageable pageable, String firstName, String lastName, String identification, String email, UserType type, UserState state, String filter) {
        return queryRepository.findAll(pageable, firstName,lastName, identification, email,  type,state,  filter);
    }

    @Override
    @Transactional
    public UserId delete(UserId id) {
        User user = this.queryRepository.findById(id);
        this.commandRepository.delete(user);
        if (messengerIsActive) {
            eventService.delete(user);
        }
        return id;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User toUpdate = this.queryRepository.findById(user.getId());

        UserFirstName userFirstName = isValid(user.getFirstName()) ? user.getFirstName() : toUpdate.getFirstName();
        UserLastName userLastName = isValid(user.getLastName()) ? user.getLastName() : toUpdate.getLastName();
        UserIdentification userIdentification = isValid(user.getIdentification())
                ? user.getIdentification()
                : toUpdate.getIdentification();
        UserEmail userEmail = isValid(user.getEmail()) ? user.getEmail() : toUpdate.getEmail();

        UserPassword userPassword = toUpdate.getPassword();
        if (isValid(user.getPassword())) {
            RulesChecker.checkRule(new UserPasswordMustBeSecureRule(user.getPassword()));
            userPassword = new UserPassword(passwordEncoder.encode(user.getPassword().value()));
        }

        UserType userType = user.getType();
        UserState userState = user.getState();
        RegistrationTokenState registrationState = toUpdate.getRegistrationState();

        UserPhone phone = isValid(user.getPhone()) ? user.getPhone() : toUpdate.getPhone();
        TelephoneOperator operator = isValid(user.getTelephoneOperator())
                ? user.getTelephoneOperator()
                : toUpdate.getTelephoneOperator();

        UserShouldChangePassword shouldChangePassword = toUpdate.getShouldChangePassword();

        UserProfileSet profiles = isValid(user.getProfiles()) ? user.getProfiles() : toUpdate.getProfiles();

        User userSave = new User(toUpdate.getId(), userFirstName, userLastName, userIdentification, userEmail,
                userPassword, userType, userState, profiles, registrationState, phone, operator,
                shouldChangePassword);

        RulesChecker.checkRule(new UserFirstNameRequiredRule(userSave.getFirstName()));
        RulesChecker.checkRule(new UserLastNameRequiredRule(userSave.getLastName()));
        RulesChecker.checkRule(new UserIdentificationRequiredRule(userSave.getIdentification()));
        RulesChecker.checkRule(new UserIdentificationMustBeUniqueRule(this, userSave));
        RulesChecker.checkRule(new UserEmailRequiredRule(userSave.getEmail()));
        RulesChecker.checkRule(new UserEmailMustBeUniqueRule(this, userSave));
        RulesChecker.checkRule(new UserPasswordRequiredRule(userSave.getPassword()));
        RulesChecker.checkRule(new UserTypeRequiredRule(userSave.getType()));
        RulesChecker.checkRule(new UserStateRequiredRule(userSave.getState()));
        RulesChecker.checkRule(new UserProfilesRequiredRule(userSave.getType(), userSave.getProfiles()));

        commandRepository.update(userSave);

        if (messengerIsActive) {
            eventService.update(userSave);
        }
    }

    @Override
    public Long countByIdentification(UserIdentification identification) {
        return queryRepository.countByIdentification(identification.value());
    }

    @Override
    public Long countByEmail(UserEmail email) {
        return queryRepository.countByEmail(email.value());
    }

    @Override
    public User findByEmail(UserEmail email) {
        return queryRepository.findByEmail(email.value());
    }

    @Override
    public User findByIdentification(UserIdentification userIdentification) {
        Optional<User> user = queryRepository.findByIdentification(userIdentification.getValue());

        if (user.isEmpty()) {
            throw new DomainException("Not valid or missed identification");
        }
        return user.get();
    }

    @Override
    @Transactional
    public Optional<RegistrationToken> registerUser(User user) {
        try {
            Optional<User> oUser = queryRepository.findByIdentification(user.getIdentification().value());

            if (oUser.isPresent()) {
                if (oUser.get().getRegistrationState() == RegistrationTokenState.VERIFICATION_ACCEPTED) {
                    throw new DomainException("User has registered before!");
                } else if (oUser.get().getRegistrationState() == RegistrationTokenState.VERIFICATION_PENDING) {
                    throw new DomainException("User registration pending of validation!");
                } else if (oUser.get().getRegistrationState() == RegistrationTokenState.VERIFICATION_BLOCKED) {
                    throw new DomainException("User registration blocked");
                }

                return Optional.empty();
            }
        } catch (Exception ex) {
            createUser(user);

            RegistrationTokenId tId = new RegistrationTokenId(UUID.randomUUID());
            RegistrationTokenOTP otp = new RegistrationTokenOTP(OTPUtil.genOTP());
            RegistrationTokenAttempt attempts = new RegistrationTokenAttempt(0);

            LocalDateTime currenDateTime = LocalDateTime.now();

            RegistrationTokenDateTime initialDateTime = new RegistrationTokenDateTime(currenDateTime);
            RegistrationTokenDateTime endingDateTime = new RegistrationTokenDateTime(
                    currenDateTime.plusMinutes(REGISTRATION_TOKEN_EXPIRE));

            RegistrationToken registrationToken = new RegistrationToken(tId, user, otp, attempts, initialDateTime,
                    endingDateTime);

            registrationCommandRepository.create(registrationToken);
            return Optional.of(registrationToken);
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public UserId validateOTP(String otp, String password) {
        Optional<RegistrationToken> registrationToken = registrationQueryRepository
                .findByOtp(new RegistrationTokenOTP(otp));

        if (registrationToken.isPresent()) {
            RegistrationToken token = registrationToken.get();

            LocalDateTime curreTime = LocalDateTime.now();

            RulesChecker.checkRule(new RegistrationTokenExpiredRule(token, curreTime), () -> {
                RegistrationTokenOTP uOtp = new RegistrationTokenOTP(OTPUtil.genOTP());
                RegistrationTokenAttempt uAttepts = new RegistrationTokenAttempt(0);

                LocalDateTime currenDateTime = LocalDateTime.now();
                RegistrationTokenDateTime uInitialDateTime = new RegistrationTokenDateTime(currenDateTime);
                RegistrationTokenDateTime uEndingDateTime = new RegistrationTokenDateTime(
                        currenDateTime.plusMinutes(REGISTRATION_TOKEN_EXPIRE));

                RegistrationToken uRegistrationToken = new RegistrationToken(token.getId(), token.getUser(), uOtp,
                        uAttepts, uInitialDateTime, uEndingDateTime);

                registrationCommandRepository.update(uRegistrationToken);
            });

            RulesChecker.checkRule(new RegistrationTokenMaxAttemptsRule(token, REGISTRATION_TOKEN_MAX_ATTEMPTS), () -> {
                User user = token.getUser();

                User toUpdate = new User(user.getId(), user.getFirstName(), user.getLastName(),
                        user.getIdentification(), user.getEmail(), user.getPassword(), user.getType(),
                        user.getState(), user.getProfiles(), RegistrationTokenState.VERIFICATION_BLOCKED,
                        user.getPhone(), user.getTelephoneOperator(),
                        user.getShouldChangePassword());

                commandRepository.update(toUpdate);
                if (messengerIsActive) {
                    eventService.update(toUpdate);
                }
            });

            User user = token.getUser();
            UserPassword uPassword = new UserPassword(passwordEncoder.encode(password));

            User toUpdate = new User(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getIdentification(),
                    user.getEmail(),
                    uPassword,
                    user.getType(),
                    user.getState(),
                    user.getProfiles(),
                    RegistrationTokenState.VERIFICATION_ACCEPTED,
                    user.getPhone(),
                    user.getTelephoneOperator(),
                    user.getShouldChangePassword());

            commandRepository.update(toUpdate);
            if (messengerIsActive) {
                eventService.update(toUpdate);
            }

            return user.getId();
        } else {
            throw new DomainException(String.format("OTP %s not found!", otp));
        }
    }

    @Override
    public Long countByIdIsNotAndEmail(UserId id, UserEmail email) {
        return queryRepository.countByIdIsNotAndEmail(id.value(), email.value());
    }

    @Override
    public Long countByIdIsNotAndIdentification(UserId id, UserIdentification identification) {
        return queryRepository.countByIdIsNotAndIdentification(id.value(), identification.value());
    }

    @Override
    @Transactional
    public void changePassword(UserIdentification identification, UserPassword oldPassword, UserPassword newPassword) {

        User user = this.findByIdentification(identification);

        RulesChecker.checkRule(new UserPasswordMatchRule(passwordEncoder, user, oldPassword));

        User nUser = new User(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getIdentification(),
                user.getEmail(),
                newPassword,
                user.getType(),
                user.getState(),
                user.getProfiles(),
                user.getRegistrationState(),
                user.getPhone(),
                user.getTelephoneOperator());

        updateUser(nUser);

    }

    private boolean isValid(Object o) {
        if (o == null)
            return false;

        if (o instanceof StringValueObject s)
            return !s.value().isBlank();
        if (o instanceof CollectionValueObject<?> c)
            return !c.value().isEmpty();

        return true;
    }

    @Override
    public Optional<RegistrationToken> findByUserId(UserId userId) {

        return registrationQueryRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public void spreadUsers() {
        List<User> allUsers = commandRepository.findAll();
        allUsers.stream().forEach(item -> {
            eventService.create(item);
        });
    }

}
