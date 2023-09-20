package ec.gob.registrocivil.identity.geographiclocation.application.command.delete;

import java.util.UUID;

import ec.gob.registrocivil.identity.geographiclocation.application.command.update.UpdateGeographicLocationRequest;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

public class DeleteGeographicLocationCommand implements ICommand {

    private UUID id;

    public DeleteGeographicLocationCommand() {
    }

    public DeleteGeographicLocationCommand(UUID id) {
        this.id = id;
    }

    public static DeleteGeographicLocationCommand fromRequest(UpdateGeographicLocationRequest request) {

        return new DeleteGeographicLocationCommand(request.getId());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteGeographicLocationMessage(id);
    }
}
