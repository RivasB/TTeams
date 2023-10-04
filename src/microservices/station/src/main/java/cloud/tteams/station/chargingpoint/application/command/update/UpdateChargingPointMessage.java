package cloud.tteams.station.chargingpoint.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class UpdateChargingPointMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "UPDATED";

    public UpdateChargingPointMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
