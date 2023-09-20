package ec.gob.registrocivil.identity.aplication.application.command.delete;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class DeleteAplicationMessage implements ICommandMessage {

    private UUID id;

    private final String command;

    public DeleteAplicationMessage(UUID id) {
        this.id = id;
        this.command = "DELETE_APPLICATION";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
