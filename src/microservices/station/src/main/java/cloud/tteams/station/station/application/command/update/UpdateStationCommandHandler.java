package cloud.tteams.station.station.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.location.domain.service.ILocationService;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.service.IStationService;
import cloud.tteams.station.station.infrastructure.util.ValidationUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UpdateStationCommandHandler implements ICommandHandler<UpdateStationCommand> {

    private final IStationService stationService;

    private final ILocationService locationService;

    public UpdateStationCommandHandler(IStationService stationService, ILocationService locationService) {
        this.stationService = stationService;
        this.locationService = locationService;
    }

    @Transactional
    @Override
    public void handle(UpdateStationCommand command) {
        ValidationUtils.isValidLongitude(command.getLongitude());
        ValidationUtils.isValidLatitude(command.getLatitude());
        Station oldStation = stationService.findById(new StationId(command.getId()));
        LocationId locationId = oldStation.getLocation().getId();
        LocationAddress address = new LocationAddress(command.getAddress());
        LocationLatitude latitude = new LocationLatitude(command.getLatitude());
        LocationLongitude longitude = new LocationLongitude(command.getLongitude());
        Location updatedLocation = new Location(locationId,address,latitude,longitude,oldStation);
        locationService.update(updatedLocation);
        Station updatedStation = new Station(oldStation.getId(),updatedLocation,command.getChargerType()
                ,oldStation.getChargingPoints(),command.getStatus());
        stationService.update(updatedStation);
    }
}
