package cloud.tteams.station.chargingpoint.domain.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import org.springframework.data.domain.Pageable;

public interface IChargingPointService {

    void create(ChargingPoint chargingPoint);

    void update(ChargingPoint chargingPoint);

    void delete(ChargingPointId chargingPointId);

    ChargingPoint findById(ChargingPointId id);

    MessagePaginatedResponse findAll(Pageable pageable);
}
