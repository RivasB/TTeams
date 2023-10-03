package cloud.tteams.station.location.application.command.delete;

import java.util.UUID;

public class DeleteLocationRequest {

    private final UUID id;

    public DeleteLocationRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
