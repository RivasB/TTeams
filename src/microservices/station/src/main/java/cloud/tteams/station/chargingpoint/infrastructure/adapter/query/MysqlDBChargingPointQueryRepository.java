package cloud.tteams.station.chargingpoint.infrastructure.adapter.query;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.station.chargingpoint.application.ChargingPointResponse;
import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointQueryRepository;
import cloud.tteams.station.chargingpoint.infrastructure.exception.ChargingPointNotFound;
import cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
@Primary
public class MysqlDBChargingPointQueryRepository implements IChargingPointQueryRepository {

    private final ISpringChargingPointReadDataJPARepository jpaRepository;

    public MysqlDBChargingPointQueryRepository(ISpringChargingPointReadDataJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ChargingPoint findById(ChargingPointId id) {
        ChargingPointDto chargingPointDto = jpaRepository.findById(id.getValue())
                .orElseThrow(ChargingPointNotFound::new);
        return chargingPointDto.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<ChargingPointDto> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }

    private MessagePaginatedResponse result(Page<ChargingPointDto> page) {
        List<ChargingPointResponse> response = page.stream()
                .map(item -> new ChargingPointResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }
}
