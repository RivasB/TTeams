package cloud.tteams.station.location.domain.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;
import org.springframework.data.domain.Pageable;

public interface ILocationService {

    void create(Location location);

    void update(Location location);

    void delete(LocationId locationId);

    Location findById(LocationId id);

    MessagePaginatedResponse findAll(Pageable pageable);
}
