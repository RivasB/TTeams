package cloud.tteams.station.chargingpoint.domain.repository;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;

public interface IChargingPointCommandRepository {
    void create(ChargingPoint chargingPoint);

    void update(ChargingPoint chargingPoint);

    void delete(ChargingPoint chargingPoint);
}
