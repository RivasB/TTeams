package cloud.tteams.station.chargingpoint.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import org.springframework.data.domain.Pageable;


public interface IChargingPointQueryRepository {
    ChargingPoint findById(ChargingPointId id);
    MessagePaginatedResponse findAll(Pageable pageable);
}
