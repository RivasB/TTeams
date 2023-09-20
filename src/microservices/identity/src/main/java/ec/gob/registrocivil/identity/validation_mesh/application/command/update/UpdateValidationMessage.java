package ec.gob.registrocivil.identity.validation_mesh.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

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
