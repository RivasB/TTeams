package cloud.tteams.identity.validation_mesh.application.command.update;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class UpdateValidationMessage implements ICommandMessage {

    private UUID id;

    private final String command = "UPDATE_VALIDATION";

    public UpdateValidationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
