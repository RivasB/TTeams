package cloud.tteams.identity.user.application.command.changepassword;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UserChangePasswordMessage implements ICommandMessage {

    private final String nui;

    private final String command = "CHANGE_PASSWORD_FOR_USER";

    public UserChangePasswordMessage(String nui) {
        this.nui = nui;
    }

    public String getNui() {
        return nui;
    }

    public String getCommand() {
        return command;
    }

}
