package ec.gob.registrocivil.identity.aplication.application.command.delete;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class DeleteApplicatinCommand implements ICommand {

    private UUID id;

    public DeleteApplicatinCommand(UUID id) {
        this.id = id;
    }

    public static DeleteApplicatinCommand fromRequest(DeleteApplicationRequest request) {

        return new DeleteApplicatinCommand(request.getId());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteAplicationMessage(id);
    }

}
