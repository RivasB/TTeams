package cloud.tteams.station.station.application.command.delete;

import java.util.UUID;

public class DeleteStationRequest {

    private UUID id;

    public DeleteStationRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
