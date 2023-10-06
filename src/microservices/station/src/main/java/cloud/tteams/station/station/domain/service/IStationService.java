package cloud.tteams.station.station.domain.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.domain.LocationLatitude;
import cloud.tteams.station.location.domain.LocationLongitude;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationId;
import org.springframework.data.domain.Pageable;

public interface IStationService {
    void create(Station station);

    void update(Station station);

    void delete(StationId stationId);

    Station findById(StationId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    Station findByProximity(LocationLatitude latitude, LocationLongitude longitude, StationChargerType vehicleChargerType);
}
