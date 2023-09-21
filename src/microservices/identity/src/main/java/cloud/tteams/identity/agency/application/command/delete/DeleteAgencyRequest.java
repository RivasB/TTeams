package cloud.tteams.identity.agency.application.command.delete;

import java.util.UUID;

public class DeleteAgencyRequest {

    private UUID id;

    public DeleteAgencyRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
