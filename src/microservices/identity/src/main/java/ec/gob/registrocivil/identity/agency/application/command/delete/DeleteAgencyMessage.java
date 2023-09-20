package ec.gob.registrocivil.identity.agency.application.command.delete;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

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
