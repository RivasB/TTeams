package cloud.tteams.station.chargingpoint.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteChargingPointMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "DELETED";

    public DeleteChargingPointMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
