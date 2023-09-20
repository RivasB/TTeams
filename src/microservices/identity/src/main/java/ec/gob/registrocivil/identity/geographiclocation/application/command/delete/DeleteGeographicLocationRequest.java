package ec.gob.registrocivil.identity.geographiclocation.application.command.delete;

import java.util.UUID;

public class DeleteGeographicLocationRequest {

    private UUID id;

    public DeleteGeographicLocationRequest() {
    }

    public DeleteGeographicLocationRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
