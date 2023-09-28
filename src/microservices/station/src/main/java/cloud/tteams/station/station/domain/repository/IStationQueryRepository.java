package cloud.tteams.station.station.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IStationQueryRepository {

    Optional<Station> findById(StationId id);

    MessagePaginatedResponse allAccessWithOutFilter(Pageable pageable);

    MessagePaginatedResponse allAccessWithFilter(Pageable pageable, String filter);
    
    public MessagePaginatedResponse findAll(Pageable pageable, String description, String code, String resource);

}
