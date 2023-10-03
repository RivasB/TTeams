package cloud.tteams.station.location.application.query.getall;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.location.domain.service.ILocationService;
import org.springframework.stereotype.Component;

@Component
public class FindAllLocationQueryHandler implements IQueryHandler<FindAllLocationQuery, MessagePaginatedResponse> {

    private final ILocationService locationService;

    public FindAllLocationQueryHandler(ILocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public MessagePaginatedResponse handle(FindAllLocationQuery query) {
        return locationService.findAll(query.getPageable());
    }
}
