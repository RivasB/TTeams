package ec.gob.registrocivil.identity.user.application.command.delete;

import java.util.UUID;

public class DeleteUserRequest {

    private UUID id;

    public DeleteUserRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
