package cloud.tteams.station.station.application.query.getbyproximity;

import cloud.tteams.share.core.domain.bus.query.IQuery;
import cloud.tteams.station.station.domain.StationChargerType;

public class FindStationByProximityQuery implements IQuery {

    private String latitude;

    private String longitude;

    private StationChargerType vehicleChargerType;

    public FindStationByProximityQuery(String latitude, String longitude, StationChargerType vehicleChargerType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleChargerType = vehicleChargerType;
    }

    public FindStationByProximityQuery(FindStationByProximityRequest request) {
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        this.vehicleChargerType = request.getVehicleChargerType();
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public StationChargerType getVehicleChargerType() {
        return vehicleChargerType;
    }
}
