package cloud.tteams.station.station.application.command.update;

import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationStatus;

import java.util.UUID;

public class UpdateStationRequest {

    private UUID id;

    private StationChargerType chargerType;

    private String address;

    private String latitude;

    private String longitude;

    private StationStatus status;

    public UpdateStationRequest(UUID id, StationChargerType chargerType, String address, String latitude,
                                String longitude, StationStatus status) {
        this.id = id;
        this.chargerType = chargerType;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    public UUID getId() {
        return id;
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

    public StationStatus getStatus() {
        return status;
    }
}
