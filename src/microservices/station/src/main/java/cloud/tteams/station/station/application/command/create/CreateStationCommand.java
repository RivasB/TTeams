package cloud.tteams.station.station.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.station.station.domain.StationChargerType;

import java.util.UUID;

public class CreateStationCommand implements ICommand {

    private UUID id;

    private StationChargerType chargerType;

    private String address;

    private String latitude;

    private String longitude;

    public CreateStationCommand(StationChargerType chargerType, String address, String latitude, String longitude) {
        this.id = UUID.randomUUID();
        this.chargerType = chargerType;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CreateStationCommand(CreateStationRequest request) {
        this.id = UUID.randomUUID();
        this.chargerType = request.getChargerType();
        this.address = request.getAddress();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateStationMessage(this.id);
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
}
