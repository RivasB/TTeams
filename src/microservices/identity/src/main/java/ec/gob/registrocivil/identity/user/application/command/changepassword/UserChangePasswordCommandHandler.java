package ec.gob.registrocivil.identity.user.application.command.changepassword;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandHandler;
import ec.gob.registrocivil.identity.user.domain.UserIdentification;
import ec.gob.registrocivil.identity.user.domain.UserPassword;
import ec.gob.registrocivil.identity.user.domain.service.IUserService;

@Component
public class UserChangePasswordCommandHandler implements ICommandHandler<UserChangePasswordCommand> {

    private final IUserService userService;

    public UserChangePasswordCommandHandler(IUserService userService) {

        this.userService = userService;
    }

    @Override
    public void handle(UserChangePasswordCommand command) {

        UserIdentification identification = new UserIdentification(command.getNui());
        UserPassword oldPassword = new UserPassword(command.getOldPassword());
        UserPassword newPassword = new UserPassword(command.getNewPassword());

        userService.changePassword(identification, oldPassword, newPassword);
    }

}
