package cloud.tteams.station.location.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteLocationMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "DELETED";

    public DeleteLocationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
