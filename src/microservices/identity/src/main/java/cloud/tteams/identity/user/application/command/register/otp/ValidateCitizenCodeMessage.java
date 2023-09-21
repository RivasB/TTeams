package cloud.tteams.identity.user.application.command.register.otp;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class ValidateCitizenCodeMessage implements ICommandMessage {

    private final String code;

    private final String command = "VALIDATE_USER_CODE";

    public ValidateCitizenCodeMessage(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getCommand() {
        return command;
    }

}
