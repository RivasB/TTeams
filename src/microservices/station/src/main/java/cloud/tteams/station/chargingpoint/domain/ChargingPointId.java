package cloud.tteams.station.chargingpoint.domain;

import cloud.tteams.share.core.domain.Identifier;

import java.util.UUID;

public class ChargingPointId extends Identifier {
    public ChargingPointId(UUID value) {
        super(value);
    }
}
