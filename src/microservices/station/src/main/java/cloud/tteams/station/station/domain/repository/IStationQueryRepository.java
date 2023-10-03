package cloud.tteams.station.station.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStationQueryRepository {

    Station findById(StationId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
