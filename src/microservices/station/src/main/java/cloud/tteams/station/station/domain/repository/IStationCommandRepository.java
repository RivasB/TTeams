package cloud.tteams.station.station.domain.repository;

import cloud.tteams.identity.access.domain.Station;

public interface IStationCommandRepository {

    void create(Station access);

    void update(Station access);

    void delete(Station access);
}
