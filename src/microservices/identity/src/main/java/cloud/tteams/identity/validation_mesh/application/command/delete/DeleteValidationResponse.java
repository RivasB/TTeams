package cloud.tteams.identity.validation_mesh.application.command.delete;

import java.util.UUID;

public class DeleteValidationResponse {

    private UUID id;

    private final String command = "DELETE_VALIDATION";

    public DeleteValidationResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
