package cloud.tteams.identity.user.application.command.register.validate;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public record ValidateUserCodeCommand(String code, String password) implements ICommand {

    public static ValidateUserCodeCommand fromRequest(ValidateUserCodeRequest request) {
        return new ValidateUserCodeCommand(request.code(), request.password());
    }

    @Override
    public ICommandMessage getMessage() {
        return new ValidateUserCodeMessage(code);
    }

}
