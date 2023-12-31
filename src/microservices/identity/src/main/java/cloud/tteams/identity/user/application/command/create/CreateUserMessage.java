package cloud.tteams.identity.user.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateUserMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "CREATE_USER";

    public CreateUserMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
