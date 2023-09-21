package cloud.tteams.identity.geographiclocation.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.identity.geographiclocation.domain.service.IGeographicLocationService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindGeographicLocationByIdQueryHandler
        implements IQueryHandler<FindGeographicLocationByIdQuery, FindGeographicLocationByIdResponse> {

    private final IGeographicLocationService geographicLocationService;

    public FindGeographicLocationByIdQueryHandler(IGeographicLocationService geographicLocationService) {
        this.geographicLocationService = geographicLocationService;
    }

    @Override
    public FindGeographicLocationByIdResponse handle(FindGeographicLocationByIdQuery query) {

        GeographicLocationId id = new GeographicLocationId(query.getId());
        GeographicLocation location = geographicLocationService.findById(id);

        return new FindGeographicLocationByIdResponse(location);
    }

}
