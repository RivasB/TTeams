package cloud.tteams.identity.geographiclocation.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteGeographicLocationMessage implements ICommandMessage {

    private UUID id;

    private String command;

    public DeleteGeographicLocationMessage(UUID id) {
        this.id = id;
        this.command = "DELETE_GEOGRAPHIC_LOCATION";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
