package cloud.tteams.station.station.domain.service;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import org.springframework.data.domain.Pageable;

public interface IStationService {

    Station findById(StationId id);

    MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String description, String code, String resource);

}
