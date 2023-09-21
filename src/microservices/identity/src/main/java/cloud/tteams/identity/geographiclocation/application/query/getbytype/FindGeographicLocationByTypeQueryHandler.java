package cloud.tteams.identity.geographiclocation.application.query.getbytype;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindGeographicLocationByTypeQueryHandler
        implements IQueryHandler<FindGeographicLocationByTypeQuery, MessagePaginatedResponse> {

    private final IGeographicLocationService geographicLocationService;

    public FindGeographicLocationByTypeQueryHandler(IGeographicLocationService geographicLocationService) {
        this.geographicLocationService = geographicLocationService;
    }

    @Override
    public MessagePaginatedResponse handle(FindGeographicLocationByTypeQuery query) {

        return geographicLocationService.getPaginatedByType(query.getPageable(), query.getFilter(), query.getType());
    }

}
