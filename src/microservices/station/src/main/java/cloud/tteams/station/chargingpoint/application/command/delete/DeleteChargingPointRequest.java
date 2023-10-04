package cloud.tteams.station.chargingpoint.application.command.delete;

import java.util.UUID;

public class DeleteChargingPointRequest {

    private final UUID id;

    public DeleteChargingPointRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
