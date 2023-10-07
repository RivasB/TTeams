package cloud.tteams.station.station.application.query.getbyproximity;

import cloud.tteams.station.station.domain.StationChargerType;

public class FindStationByProximityRequest {

    private String latitude;

    private String longitude;

    private StationChargerType vehicleChargerType;

    public FindStationByProximityRequest(String latitude, String longitude, StationChargerType vehicleChargerType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.vehicleChargerType = vehicleChargerType;
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
