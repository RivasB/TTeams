package cloud.tteams.station.station.domain.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.repository.IStationCommandRepository;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import org.springframework.data.domain.Pageable;

public interface IStationService {
    void create(Station station);

    void update(Station station);

    void delete(StationId stationId);

    Station findById(StationId id);

    MessagePaginatedResponse findAll(Pageable pageable);
}
