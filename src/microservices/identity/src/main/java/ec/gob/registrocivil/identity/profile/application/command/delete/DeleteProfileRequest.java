package ec.gob.registrocivil.identity.profile.application.command.delete;

import java.util.UUID;

public class DeleteProfileRequest {

    private UUID id;

    public DeleteProfileRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
