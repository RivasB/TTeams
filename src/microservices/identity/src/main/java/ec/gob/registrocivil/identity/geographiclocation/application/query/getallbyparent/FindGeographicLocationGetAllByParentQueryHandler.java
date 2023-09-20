package ec.gob.registrocivil.identity.geographiclocation.application.query.getallbyparent;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindGeographicLocationGetAllByParentQueryHandler
        implements IQueryHandler<FindGeographicLocationGetAllByParentQuery, MessagePaginatedResponse> {

    private final IGeographicLocationService geographicLocationService;

    public FindGeographicLocationGetAllByParentQueryHandler(IGeographicLocationService geographicLocationService) {
        this.geographicLocationService = geographicLocationService;
    }

    @Override
    public MessagePaginatedResponse handle(FindGeographicLocationGetAllByParentQuery query) {
        GeographicLocationId id = new GeographicLocationId(query.getId());
        GeographicLocation location = geographicLocationService.findById(id);
        
        return geographicLocationService.findByParent(query.getPageable(), location.getId());
    }

}
