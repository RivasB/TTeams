package cloud.tteams.station.chargingpoint.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class CreateChargingPointCommand implements ICommand {

    private UUID id;

    private int powerLevel;

    private UUID station;

    public CreateChargingPointCommand(int powerLevel, UUID station) {
        this.id = UUID.randomUUID();
        this.powerLevel = powerLevel;
        this.station = station;
    }

    public CreateChargingPointCommand(CreateChargingPointRequest request){
        this.id = UUID.randomUUID();
        this.powerLevel = request.getPowerLevel();
        this.station = request.getStation();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateChargingPointMessage(this.id);
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
