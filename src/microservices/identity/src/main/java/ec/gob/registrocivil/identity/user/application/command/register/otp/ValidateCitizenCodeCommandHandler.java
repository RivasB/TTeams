package ec.gob.registrocivil.identity.user.application.command.register.otp;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import ec.gob.registrocivil.identity.user.domain.service.IUserService;

@Component
public class ValidateCitizenCodeCommandHandler implements ICommandHandler<ValidateCitizenCodeCommand> {

    private IUserService userService;

    public ValidateCitizenCodeCommandHandler(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void handle(ValidateCitizenCodeCommand command) {

        userService.validateOTP(command.getCode(), command.getPassword());
    }

}
