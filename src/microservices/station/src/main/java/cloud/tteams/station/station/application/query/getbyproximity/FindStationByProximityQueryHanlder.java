package cloud.tteams.station.station.application.query.getbyproximity;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.station.location.domain.LocationLatitude;
import cloud.tteams.station.location.domain.LocationLongitude;
import cloud.tteams.station.station.application.StationResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.service.IStationService;
import cloud.tteams.station.station.infrastructure.util.ValidationUtils;
import org.springframework.stereotype.Component;

@Component
public class FindStationByProximityQueryHanlder implements IQueryHandler<FindStationByProximityQuery, StationResponse> {

    private final IStationService stationService;

    public FindStationByProximityQueryHanlder(IStationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public StationResponse handle(FindStationByProximityQuery query) {
        ValidationUtils.isValidLongitude(query.getLongitude());
        ValidationUtils.isValidLatitude(query.getLatitude());
        LocationLatitude latitude = new LocationLatitude(query.getLatitude());
        LocationLongitude longitude = new LocationLongitude(query.getLongitude());
        Station station = stationService.findByProximity(latitude, longitude, query.getVehicleChargerType());
        return  new StationResponse(station);
    }
}
