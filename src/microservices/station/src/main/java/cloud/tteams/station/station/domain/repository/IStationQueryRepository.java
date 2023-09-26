package cloud.tteams.station.station.domain.repository;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface IStationQueryRepository {

    Optional<Station> findById(AccessId id);

    MessagePaginatedResponse allAccessWithOutFilter(Pageable pageable);

    MessagePaginatedResponse allAccessWithFilter(Pageable pageable, String filter);

    Optional<Station> findByCode(String code);

    Long countByIdIsNotAndCode(UUID id, String code);
    
    public MessagePaginatedResponse findAll(Pageable pageable, String description, String code, String resource);

}
