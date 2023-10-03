package cloud.tteams.station.location.application.command.update;

import java.util.UUID;

public class UpdateLocationRequest {
    private  final UUID id;

    private final String address;

    private final String latitude;

    private final String longitude;

    public UpdateLocationRequest(UUID id, String address, String latitude, String longitude) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getId() {
        return id;
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
