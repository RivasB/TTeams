package ec.gob.registrocivil.identity.aplication.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class UpdateAplicationMessage implements ICommandMessage {

    private final UUID id;

    private final String command = "UPDATE_APLICATION";

    public UpdateAplicationMessage(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
