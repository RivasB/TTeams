package ec.gob.registrocivil.identity.user.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class UpdateUserMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "UPDATE_USER";

    public UpdateUserMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
