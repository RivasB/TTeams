package ec.gob.registrocivil.identity.geographiclocation.application.query.getbyid;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.service.IGeographicLocationService;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
