package cloud.tteams.identity.user.application.command.changepassword;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public record UserChangePasswordCommand(String email, String oldPassword, String newPassword) implements ICommand {

    public static UserChangePasswordCommand fromRequest(UserChangePasswordRequest request) {
        return new UserChangePasswordCommand(request.email(), request.oldPassword(), request.newPassword());
    }

    @Override
    public ICommandMessage getMessage() {
        return new UserChangePasswordMessage(email);
    }

}
