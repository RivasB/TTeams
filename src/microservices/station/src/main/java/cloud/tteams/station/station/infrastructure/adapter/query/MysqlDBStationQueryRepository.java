package cloud.tteams.station.station.infrastructure.adapter.query;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.station.application.StationResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.repository.IStationQueryRepository;
import cloud.tteams.station.station.infrastructure.exception.StationNotFoundException;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Primary
public class MysqlDBStationQueryRepository implements IStationQueryRepository {
    private final ISpringStationReadDataJPARepository jpaRepository;

    public MysqlDBStationQueryRepository(final ISpringStationReadDataJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Station findById(StationId id) {
        StationDto stationDto = jpaRepository.findById(id.value()).orElseThrow(StationNotFoundException::new);
        return stationDto.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<StationDto> stationDtoPage = jpaRepository.findAll(pageable);
        return this.result(stationDtoPage);
    }

    /*
     * Usado por los metodos: findAll
     */
    private MessagePaginatedResponse result(Page<StationDto> stationDtoPage) {
        List<StationResponse> responses = stationDtoPage.stream().map(item -> {
            return new StationResponse(item.toAggregate());
        }).toList();
        return new MessagePaginatedResponse(responses, stationDtoPage);
    }

}
