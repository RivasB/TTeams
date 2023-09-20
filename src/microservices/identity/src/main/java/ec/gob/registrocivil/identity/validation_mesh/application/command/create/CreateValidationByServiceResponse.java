package ec.gob.registrocivil.identity.validation_mesh.application.command.create;

import java.util.UUID;

public class CreateValidationByServiceResponse {

    private UUID id;

    private final String command = "CREATE_VALIDATION_BY_SERVICE";

    public CreateValidationByServiceResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

}
