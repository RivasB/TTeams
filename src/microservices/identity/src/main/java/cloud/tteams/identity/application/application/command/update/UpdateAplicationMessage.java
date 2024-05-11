package cloud.tteams.identity.application.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateAplicationMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "UPDATE_APLICATION";

    public UpdateAplicationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
