package cloud.tteams.identity.user.application.command.changepassword;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UserChangePasswordCommand implements ICommand {

    private String nui;

    private String oldPassword;

    private String newPassword;

    public UserChangePasswordCommand(String nui, String oldPassword, String newPassword) {
        this.nui = nui;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public static UserChangePasswordCommand fromRequest(UserChangePasswordRequest request) {

        return new UserChangePasswordCommand(request.getNui(), request.getOldPassword(), request.getNewPassword());
    }

    public String getNui() {
        return nui;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    @Override
    public ICommandMessage getMessage() {

        return new UserChangePasswordMessage(nui);
    }

}
