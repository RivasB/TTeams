package cloud.tteams.identity.user.application.command.register.data;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public record RegisterUserCommand(UUID id, String firstName, String lastName, String email, String phone,
                                  String password) implements ICommand {

    public static RegisterUserCommand fromRequest(RegisterUserRequest request) {
        return new RegisterUserCommand(
                UUID.randomUUID(), request.firstName(), request.lastName(),
                request.email(), request.phone(), request.password());
    }

    @Override
    public ICommandMessage getMessage() {
        return new RegisterUserMessage(id);
    }
}
