package cloud.tteams.station.station.application.command.create;

import cloud.tteams.station.station.domain.StationChargerType;

public class CreateStationRequest {

    private final StationChargerType chargerType;

    private final String address;

    private final String latitude;

    private final String longitude;

    public CreateStationRequest(StationChargerType chargerType, String address, String latitude, String longitude) {
        this.chargerType = chargerType;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public StationChargerType getChargerType() {
        return chargerType;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
