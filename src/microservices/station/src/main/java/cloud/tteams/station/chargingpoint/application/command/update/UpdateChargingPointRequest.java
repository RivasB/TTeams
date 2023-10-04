package cloud.tteams.station.chargingpoint.application.command.update;

import java.util.UUID;

public class UpdateChargingPointRequest {

    private UUID id;

    private int powerLevel;

    private UUID station;

    public UpdateChargingPointRequest(UUID id, int powerLevel, UUID station) {
        this.id = id;
        this.powerLevel = powerLevel;
        this.station = station;
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
