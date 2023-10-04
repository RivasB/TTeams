package cloud.tteams.station.station.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationStatus;

import java.util.UUID;

public class UpdateStationCommand implements ICommand {

    private UUID id;

    private StationChargerType chargerType;

    private String address;

    private String latitude;

    private String longitude;

    private StationStatus status;

    public UpdateStationCommand(UUID id, StationChargerType chargerType, String address, String latitude,
                                String longitude, StationStatus status) {
        this.id = id;
        this.chargerType = chargerType;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }

    public UpdateStationCommand(UpdateStationRequest request) {
        this.id = request.getId();
        this.chargerType = request.getChargerType();
        this.address = request.getAddress();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        this.status = request.getStatus();
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateStationMessage(this.id);
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
