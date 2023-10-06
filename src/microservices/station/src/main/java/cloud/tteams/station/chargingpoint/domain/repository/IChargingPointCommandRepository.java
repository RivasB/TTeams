package cloud.tteams.station.chargingpoint.domain.repository;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;

public interface IChargingPointCommandRepository {
    void create(ChargingPoint chargingPoint);

    void update(ChargingPoint chargingPoint);

    void delete(ChargingPointId chargingPointId);
}
