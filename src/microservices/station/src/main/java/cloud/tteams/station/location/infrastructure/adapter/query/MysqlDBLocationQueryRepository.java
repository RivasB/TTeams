package cloud.tteams.station.location.infrastructure.adapter.query;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.location.application.LocationResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;
import cloud.tteams.station.location.domain.repository.ILocationQueryRepository;
import cloud.tteams.station.location.infrastructure.exception.LocationNotFoundException;
import cloud.tteams.station.location.infrastructure.repository.hibernate.LocationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class MysqlDBLocationQueryRepository implements ILocationQueryRepository {

    private final ISpringLocationReadDataJPARepository jpaRepository;

    public MysqlDBLocationQueryRepository(ISpringLocationReadDataJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Location findById(LocationId id) {
        LocationDto locationDto = jpaRepository.findById(id.getValue())
                .orElseThrow(LocationNotFoundException::new);
        return locationDto.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<LocationDto> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }

    private MessagePaginatedResponse result(Page<LocationDto> page) {
        List<LocationResponse> response = page.stream()
                .map(item -> new LocationResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }
}
