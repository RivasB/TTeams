package cloud.tteams.station.station.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class CreateStationMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "CREATED";

    public CreateStationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
