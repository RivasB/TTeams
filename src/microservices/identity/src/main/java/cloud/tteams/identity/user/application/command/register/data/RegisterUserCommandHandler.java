package cloud.tteams.identity.user.application.command.register.data;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.identity.user.infrastructure.adapter.SuperUserDataLoader;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.share.email.domain.service.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RegisterUserCommandHandler implements ICommandHandler<RegisterUserCommand> {

    private static final Logger log = LoggerFactory.getLogger(RegisterUserCommandHandler.class);
    private final IUserService userService;
    private final IEmailService mailService;
    private final IProfileService profileService;

    public RegisterUserCommandHandler(IUserService userService, IEmailService mailService, IProfileService profileService) {
        this.userService = userService;
        this.mailService = mailService;
        this.profileService = profileService;
    }

    @Override
    public void handle(RegisterUserCommand command) {
        Profile profile = profileService.findById(UUID.fromString(SuperUserDataLoader.USER_PROFILE_UUID));
        User user = new User(command.id(), command.firstName(), command.lastName(), null, command.email(),
                command.password(), UserType.USER, UserState.ACTIVE, profile, RegistrationTokenState.VERIFICATION_PENDING,
                command.phone(), false);
        try {
            Optional<RegistrationToken> token = userService.registerUser(user);
            token.ifPresent(registrationToken -> mailService.sendSimpleOTPEmail(user.getEmail(), "Registro exitoso. Verifica tu cuenta", registrationToken.getOtp()));
        }catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }

    }

}
