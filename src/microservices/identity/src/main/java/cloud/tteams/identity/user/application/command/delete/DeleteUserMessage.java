package cloud.tteams.identity.user.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteUserMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "DELETE_USER";

    public DeleteUserMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
