package cloud.tteams.identity.organization.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteAgencyMessage implements ICommandMessage {

    private UUID id;

    private final String command;

    public DeleteAgencyMessage(UUID id) {
        this.id = id;
        this.command = "DELETE_AGENCY";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
