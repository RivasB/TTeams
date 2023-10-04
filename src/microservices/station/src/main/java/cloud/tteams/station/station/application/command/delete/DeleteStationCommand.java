package cloud.tteams.station.station.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteStationCommand implements ICommand {

    private UUID id;

    public DeleteStationCommand(UUID id) {
        this.id = id;
    }

    public DeleteStationCommand(DeleteStationRequest request) {
        this.id = request.getId();
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteStationMessage(this.id);
    }

    public UUID getId() {
        return id;
    }
}
