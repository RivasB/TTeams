package cloud.tteams.identity.user.application.command.register.validate;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class ValidateUserCodeCommandHandler implements ICommandHandler<ValidateUserCodeCommand> {

    private final IUserService userService;

    public ValidateUserCodeCommandHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(ValidateUserCodeCommand command) {

        userService.validateOTP(command.code(), command.password());
    }

}
