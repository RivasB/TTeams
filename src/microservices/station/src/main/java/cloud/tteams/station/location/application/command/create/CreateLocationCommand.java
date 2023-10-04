package cloud.tteams.station.location.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class CreateLocationCommand implements ICommand {

    private final UUID id;

    private String address;

    private String latitude;

    private String longitude;

    private UUID station;

    public CreateLocationCommand(String address, String latitude, String longitude, UUID station) {
        this.id = UUID.randomUUID();
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station = station;
    }

    public CreateLocationCommand(CreateLocationRequest request){
        this.id = UUID.randomUUID();
        this.address = request.getAddress();
        this.latitude = request.getLatitude();
        this.longitude = request.getLongitude();
        this.station = request.getStation();
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateLocationMessage(this.id);
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

    public UUID getStation() {
        return station;
    }
}
