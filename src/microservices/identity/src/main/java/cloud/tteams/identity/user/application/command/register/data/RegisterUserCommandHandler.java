package cloud.tteams.identity.user.application.command.register.data;

import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.service.IUserService;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.share.email.domain.service.IEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RegisterUserCommandHandler implements ICommandHandler<RegisterUserCommand> {

    private static final Logger log = LoggerFactory.getLogger(RegisterUserCommandHandler.class);
    private final IUserService userService;
    private final IEmailService mailService;

    public RegisterUserCommandHandler(IUserService userService, IEmailService mailService) {
        this.userService = userService;
        this.mailService = mailService;
    }

    @Override
    public void handle(RegisterUserCommand command) {
        User user = new User(command.id(), command.firstName(), command.lastName(), null, command.email(),
                command.password(), UserType.USER, UserState.ACTIVE, null, RegistrationTokenState.VERIFICATION_PENDING,
                command.phone(), false);
        try {
            Optional<RegistrationToken> token = userService.registerUser(user);
            token.ifPresent(registrationToken -> mailService.sendSimpleOTPEmail(user.getEmail(), "Registro exitoso. Verifica tu cuenta", registrationToken.getOtp()));
        }catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }

    }

}
