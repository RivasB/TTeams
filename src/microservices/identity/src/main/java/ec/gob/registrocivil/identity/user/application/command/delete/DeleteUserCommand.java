package ec.gob.registrocivil.identity.user.application.command.delete;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;
import ec.gob.registrocivil.identity.telephone_operator.application.command.delete.DeleteTelephoneOperatorMessage;

public class DeleteUserCommand implements ICommand {

    private UUID id;

    public DeleteUserCommand(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteUserMessage(id);
    }

}
