package cloud.tteams.station.location.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class UpdateLocationCommand implements ICommand {
    private  UUID id;

    private String address;

    private String latitude;

    private String longitude;

    public UpdateLocationCommand(UUID id, String address, String latitude, String longitude) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UpdateLocationCommand fromRequest(UpdateLocationRequest request){
        this.id = request.getId();
        this.address = request.getAddress();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        return new UpdateLocationCommand(id,address,latitude,longitude);
    }

    @Override
    public ICommandMessage getMessage() {
        return new UpdateLocationMessage(this.id);
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
