package cloud.tteams.identity.aplication.application.command.delete;

import java.util.UUID;

public class DeleteApplicationRequest {

    private UUID id;

    public DeleteApplicationRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
