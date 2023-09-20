package ec.gob.registrocivil.identity.agency.application.command.delete;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class DeleteAgencyCommand implements ICommand {

    private UUID id;

    public DeleteAgencyCommand(UUID id) {
        this.id = id;
    }

    public static DeleteAgencyCommand fromRequest(DeleteAgencyRequest request) {

        return new DeleteAgencyCommand(request.getId());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteAgencyMessage(id);
    }

}
