package cloud.tteams.identity.telephone_operator.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteTelephoneOperatorMessage implements ICommandMessage {

    private UUID id;

    private final String command;

    public DeleteTelephoneOperatorMessage(UUID id) {
        this.id = id;
        this.command = "DELETE_TELEPHONE_OPERATOR";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
