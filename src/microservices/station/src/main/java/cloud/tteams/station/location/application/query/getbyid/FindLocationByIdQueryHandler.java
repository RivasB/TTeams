package cloud.tteams.station.location.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.location.application.LocationResponse;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.LocationId;
import cloud.tteams.station.location.domain.service.ILocationService;
import org.springframework.stereotype.Component;

@Component
public class FindLocationByIdQueryHandler implements IQueryHandler<FindLocationByIdQuery, LocationResponse> {

    private final ILocationService locationService;

    public FindLocationByIdQueryHandler(ILocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public LocationResponse handle(FindLocationByIdQuery query) {
        LocationId id = new LocationId(query.getId());
        Location location = locationService.findById(id);
        return new LocationResponse(location);
    }
}
