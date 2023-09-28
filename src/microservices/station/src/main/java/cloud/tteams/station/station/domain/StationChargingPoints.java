package cloud.tteams.station.station.domain;

import cloud.tteams.share.core.domain.CollectionValueObject;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;

import java.util.Collection;

public class StationChargingPoints extends CollectionValueObject<ChargingPoint> {
    public StationChargingPoints(Collection<ChargingPoint> value) {
        super(value);
    }
}
