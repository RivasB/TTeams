package cloud.tteams.identity.validation_mesh.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateValidationMessage implements ICommandMessage {

    private UUID id;

    private final String command = "CREATE_VALIDATION";

    public CreateValidationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
