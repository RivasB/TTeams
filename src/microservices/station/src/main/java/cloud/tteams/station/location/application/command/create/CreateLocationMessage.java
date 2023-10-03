package cloud.tteams.station.location.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class CreateLocationMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "CREATED";

    public CreateLocationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
