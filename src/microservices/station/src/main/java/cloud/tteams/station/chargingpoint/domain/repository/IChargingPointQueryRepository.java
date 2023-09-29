package cloud.tteams.station.chargingpoint.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.location.domain.Location;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IChargingPointQueryRepository {
    Optional<Location> findById(ChargingPointId id);
    MessagePaginatedResponse findAll(Pageable pageable);
}
