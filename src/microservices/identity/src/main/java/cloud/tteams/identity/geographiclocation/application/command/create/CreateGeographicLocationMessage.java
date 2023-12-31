package cloud.tteams.identity.geographiclocation.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateGeographicLocationMessage implements ICommandMessage {

    private UUID id;

    private String command;

    public CreateGeographicLocationMessage(UUID id) {
        this.id = id;
        this.command = "CREATE_GEOGRAPHIC_LOCATION";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
