package cloud.tteams.identity.user.application.command.register.otp;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class ValidateCitizenCodeCommand implements ICommand {

    private String code;

    private String password;

    public ValidateCitizenCodeCommand(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public static ValidateCitizenCodeCommand fromRequest(ValidateCitizenCodeRequest request) {

        return new ValidateCitizenCodeCommand(request.getCode(), request.getPassword());
    }

    public String getCode() {
        return code;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public ICommandMessage getMessage() {
        return new ValidateCitizenCodeMessage(code);
    }

}
