package cloud.tteams.station.location.application;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.station.location.domain.Location;

import java.util.UUID;

public class LocationResponse implements IResponse {
    private final UUID id;
    private final String address;
    private final String latitude;
    private final String longitude;

    public LocationResponse(UUID id, String address, String latitude, String longitude) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public LocationResponse(Location location){
        this.id = location.getId().getValue();
        this.address = location.getAddress().getValue();
        this.latitude = location.getLatitude().getValue();
        this.longitude = location.getLongitude().getValue();
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
