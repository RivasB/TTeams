package cloud.tteams.identity.agency.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateAgencyMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "UPDATE_AGENCY";

    public UpdateAgencyMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
