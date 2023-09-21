package cloud.tteams.identity.geographiclocation.application.query.getallbyparent;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

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
