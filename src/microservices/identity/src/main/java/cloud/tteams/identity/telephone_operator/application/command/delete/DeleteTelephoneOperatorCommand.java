package cloud.tteams.identity.telephone_operator.application.command.delete;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

public class DeleteTelephoneOperatorCommand implements ICommand {

    private UUID id;

    public DeleteTelephoneOperatorCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteTelephoneOperatorMessage(id);
    }

}
