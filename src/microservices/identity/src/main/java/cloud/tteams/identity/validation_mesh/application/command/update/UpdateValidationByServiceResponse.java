package cloud.tteams.identity.validation_mesh.application.command.update;

import java.util.UUID;

public class UpdateValidationByServiceResponse {

    private UUID id;

    private final String command = "UPDATE_VALIDATION_BY_SERVICE";

    public UpdateValidationByServiceResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
