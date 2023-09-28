package cloud.tteams.station.station.domain.repository;


import cloud.tteams.station.station.domain.Station;

public interface IStationCommandRepository {

    void create(Station station);

    void update(Station station);

    void delete(Station station);
}
