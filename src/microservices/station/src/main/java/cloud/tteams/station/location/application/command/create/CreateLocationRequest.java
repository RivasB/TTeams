package cloud.tteams.station.location.application.command.create;

import java.util.UUID;

public class CreateLocationRequest {
    private final String address;

    private final String latitude;

    private final String longitude;

    private final UUID station;

    public CreateLocationRequest(String address, String latitude, String longitude, UUID station) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station = station;
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

    public UUID getStation() {
        return station;
    }
}
