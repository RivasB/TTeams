package cloud.tteams.station.chargingpoint.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class DeleteChargingPointCommand implements ICommand {

    private final UUID id;

    public DeleteChargingPointCommand(UUID id) {
        this.id = id;
    }

    public DeleteChargingPointCommand(DeleteChargingPointRequest request) {
        this.id = request.getId();
    }

    @Override
    public ICommandMessage getMessage() {
        return new DeleteChargingPointMessage(this.id);
    }

    public UUID getId() {
        return id;
    }
}
