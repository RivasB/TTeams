package cloud.tteams.station.station.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.location.domain.service.ILocationService;
import cloud.tteams.station.station.domain.*;
import cloud.tteams.station.station.domain.service.IStationService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Component
public class CreateStationCommandHandler implements ICommandHandler<CreateStationCommand> {

    private final IStationService stationService;

    private final ILocationService locationService;

    public CreateStationCommandHandler(IStationService stationService, ILocationService locationService) {
        this.stationService = stationService;
        this.locationService = locationService;
    }

    @Transactional
    @Override
    public void handle(CreateStationCommand command) {
        LocationId locationId = new LocationId(UUID.randomUUID());
        LocationAddress address = new LocationAddress(command.getAddress());
        LocationLatitude latitude = new LocationLatitude(command.getLatitude());
        LocationLongitude longitude = new LocationLongitude(command.getLongitude());
        StationId id = new StationId(command.getId());
        StationChargerType chargerType = command.getChargerType();
        StationChargingPoints chargingPoints = new StationChargingPoints(new ArrayList<>());
        StationStatus status = StationStatus.AVAILABLE;
        Station station = new Station(id,null,chargerType,chargingPoints,status);
        stationService.create(station);
        Location location = new Location(locationId,address,latitude,longitude,station);
        locationService.create(location);
    }
}
