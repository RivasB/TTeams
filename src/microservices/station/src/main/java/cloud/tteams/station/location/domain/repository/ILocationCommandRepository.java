package cloud.tteams.station.location.domain.repository;

import cloud.tteams.station.location.domain.Location;

public interface ILocationCommandRepository {
    void create(Location location);

    void update(Location location);

    void delete(Location location);
}
