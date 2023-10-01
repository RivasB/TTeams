package cloud.tteams.station.location.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;
import org.springframework.data.domain.Pageable;


public interface ILocationQueryRepository {
    Location findById(LocationId id);
    MessagePaginatedResponse findAll(Pageable pageable);
}
