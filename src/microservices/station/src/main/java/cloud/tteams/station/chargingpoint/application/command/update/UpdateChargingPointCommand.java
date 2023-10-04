package cloud.tteams.station.chargingpoint.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class UpdateChargingPointCommand implements ICommand {

    private UUID id;

    private int powerLevel;

    private UUID station;

    public UpdateChargingPointCommand(UUID id, int powerLevel, UUID station) {
        this.id = id;
        this.powerLevel = powerLevel;
        this.station = station;
    }

    public UpdateChargingPointCommand(UpdateChargingPointRequest request){
        this.id = request.getId();
        this.powerLevel = request.getPowerLevel();
        this.station = request.getStation();
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateChargingPointMessage(this.id);
    }

    public UUID getId() {
        return id;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public UUID getStation() {
        return station;
    }
}
