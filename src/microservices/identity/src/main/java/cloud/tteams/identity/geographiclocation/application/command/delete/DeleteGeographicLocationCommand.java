package cloud.tteams.identity.geographiclocation.application.command.delete;

import java.util.UUID;

import cloud.tteams.identity.geographiclocation.application.command.update.UpdateGeographicLocationRequest;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

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
