package ec.gob.registrocivil.identity.geographiclocation.application.query.getbytype;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
