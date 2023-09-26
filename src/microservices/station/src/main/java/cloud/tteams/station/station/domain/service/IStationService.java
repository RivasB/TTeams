package cloud.tteams.station.station.domain.service;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.data.domain.Pageable;

public interface IStationService {

    Station findById(AccessId id);

    Station findByCode(AccessCode code);

    MessagePaginatedResponse getPaginatedAccess(Pageable pageable, String description, String code, String resource);

    Long countByIdIsNotAndCode(AccessId id, AccessCode code);

}
