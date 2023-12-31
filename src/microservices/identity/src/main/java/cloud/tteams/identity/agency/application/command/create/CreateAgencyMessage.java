package cloud.tteams.identity.agency.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateAgencyMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "CREATE_AGENCY";

    public CreateAgencyMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
