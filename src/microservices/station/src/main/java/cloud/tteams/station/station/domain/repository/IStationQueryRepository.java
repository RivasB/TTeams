package cloud.tteams.station.station.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface IStationQueryRepository {

    Optional<Station> findById(StationId id);
    MessagePaginatedResponse findAll(Pageable pageable);

}
