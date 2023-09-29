package cloud.tteams.station.location.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ILocationQueryRepository {
    Optional<Location> findById(LocationId id);
    MessagePaginatedResponse findAll(Pageable pageable);
}
