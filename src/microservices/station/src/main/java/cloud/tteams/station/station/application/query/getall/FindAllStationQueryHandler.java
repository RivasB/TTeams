package cloud.tteams.station.station.application.query.getall;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.stereotype.Component;

@Component
public class FindAllStationQueryHandler implements IQueryHandler<FindAllStationQuery, MessagePaginatedResponse> {

    private final IStationService stationService;

    public FindAllStationQueryHandler(IStationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public MessagePaginatedResponse handle(FindAllStationQuery query) {
        return stationService.findAll(query.getPageable());
    }
}
