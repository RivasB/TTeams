package ec.gob.registrocivil.identity.geographiclocation.application.query.getall;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindGeographicLocationWithFilterQueryHandler
        implements IQueryHandler<FindGeographicLocationWithFilterQuery, MessagePaginatedResponse> {

    private final IGeographicLocationService geographicLocationService;

    public FindGeographicLocationWithFilterQueryHandler(IGeographicLocationService geographicLocationService) {
        this.geographicLocationService = geographicLocationService;
    }

    @Override
    public MessagePaginatedResponse handle(FindGeographicLocationWithFilterQuery query) {

        return geographicLocationService.getPaginatedGeographicLocation(query.getPageable(), query.getFilter());
    }

}
