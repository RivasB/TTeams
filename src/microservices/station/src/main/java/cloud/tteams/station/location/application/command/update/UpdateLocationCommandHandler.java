package cloud.tteams.station.location.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.location.domain.service.ILocationService;
import cloud.tteams.station.station.domain.Station;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateLocationCommandHandler implements ICommandHandler<UpdateLocationCommand> {

    private final ILocationService locationService;

    public UpdateLocationCommandHandler(ILocationService locationService) {
        this.locationService = locationService;
    }

    @Transactional
    @Override
    public void handle(UpdateLocationCommand command) {
        LocationId id = new LocationId(command.getId());
        Station station = locationService.findById(id).getStation();
        LocationAddress address = new LocationAddress(command.getAddress());
        LocationLatitude latitude = new LocationLatitude(command.getLatitude());
        LocationLongitude longitude = new LocationLongitude(command.getLongitude());
        Location update = new Location(id,address,latitude,longitude,station);
        locationService.update(update);
    }
}
