package cloud.tteams.station.location.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class UpdateLocationMessage implements ICommandMessage {
    private final UUID id;

    private final String command = "UPDATED";

    public UpdateLocationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
