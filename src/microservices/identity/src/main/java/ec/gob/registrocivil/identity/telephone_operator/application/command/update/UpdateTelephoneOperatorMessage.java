package ec.gob.registrocivil.identity.telephone_operator.application.command.update;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class UpdateTelephoneOperatorMessage implements ICommandMessage {

    private UUID id;

    private final String command;

    public UpdateTelephoneOperatorMessage(UUID id) {
        this.id = id;
        this.command = "UPDATE_TELEPHONE_OPERATOR";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
