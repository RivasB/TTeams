package cloud.tteams.station.chargingpoint.application.command.create;

import java.util.UUID;

public class CreateChargingPointRequest {

    private final int powerLevel;

    private final UUID station;

    public CreateChargingPointRequest(int powerLevel, UUID station) {
        this.powerLevel = powerLevel;
        this.station = station;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public UUID getStation() {
        return station;
    }
}
