package cloud.tteams.identity.telephone_operator.application.command.create;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class CreateTelephoneOperatorMessage implements ICommandMessage {

    private UUID id;

    private final String command;

    public CreateTelephoneOperatorMessage(UUID id) {
        this.id = id;
        this.command = "CREATE_TELEPHONE_OPERATOR";
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }
}
