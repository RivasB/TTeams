package cloud.tteams.station.chargingpoint.application;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;

import java.util.UUID;

public class ChargingPointResponse implements IResponse {
    private final UUID id;
    private final int powerLevel;

    public ChargingPointResponse(UUID id, int powerLevel) {
        this.id = id;
        this.powerLevel = powerLevel;
    }

    public ChargingPointResponse(ChargingPoint chargingPoint) {
        this.id = chargingPoint.id().getValue();
        this.powerLevel = chargingPoint.powerLevel().getValue();
    }

    public UUID getId() {
        return id;
    }

    public int getPowerLevel() {
        return powerLevel;
    }
}
