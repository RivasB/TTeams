package cloud.tteams.identity.user.application.command.changepassword;

import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.identity.user.domain.service.IUserService;

@Component
public class UserChangePasswordCommandHandler implements ICommandHandler<UserChangePasswordCommand> {

    private final IUserService userService;

    public UserChangePasswordCommandHandler(IUserService userService) {

        this.userService = userService;
    }

    @Override
    public void handle(UserChangePasswordCommand command) {
        userService.changePassword(command.email(), command.oldPassword(), command.newPassword());
    }

}
