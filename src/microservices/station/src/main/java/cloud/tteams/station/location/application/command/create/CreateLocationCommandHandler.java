package cloud.tteams.station.location.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.location.domain.service.ILocationService;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CreateLocationCommandHandler implements ICommandHandler<CreateLocationCommand> {

    private final ILocationService locationService;

    private final IStationService stationService;

    public CreateLocationCommandHandler(ILocationService locationService, IStationService stationService) {
        this.locationService = locationService;
        this.stationService = stationService;
    }

    @Transactional
    @Override
    public void handle(CreateLocationCommand command) {
        StationId stationId = new StationId(command.getStation());
        Station station = stationService.findById(stationId);
        LocationId id = new LocationId(command.getId());
        LocationAddress address = new LocationAddress(command.getAddress());
        LocationLatitude latitude = new LocationLatitude(command.getLatitude());
        LocationLongitude longitude = new LocationLongitude(command.getLongitude());
        Location location = new Location(id,address,latitude,longitude,station);
        locationService.create(location);
    }
}
