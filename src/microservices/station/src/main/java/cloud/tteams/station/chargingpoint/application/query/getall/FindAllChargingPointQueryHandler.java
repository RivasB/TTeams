package cloud.tteams.station.chargingpoint.application.query.getall;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.chargingpoint.domain.service.IChargingPointService;
import org.springframework.stereotype.Component;

@Component
public class FindAllChargingPointQueryHandler implements IQueryHandler<FindAllChargingPointQuery, MessagePaginatedResponse> {

    private final IChargingPointService chargingPointService;

    public FindAllChargingPointQueryHandler(IChargingPointService chargingPointService) {
        this.chargingPointService = chargingPointService;
    }

    @Override
    public MessagePaginatedResponse handle(FindAllChargingPointQuery query) {
        return chargingPointService.findAll(query.getPageable());
    }
}
