package cloud.tteams.identity.geographiclocation.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateGeographicLocationMessage implements ICommandMessage {

    private UUID id;

    private String command;

    public UpdateGeographicLocationMessage(UUID id) {
        this.id = id;
        this.command = "UPDATE_GEOGRAPHIC_LOCATION";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
