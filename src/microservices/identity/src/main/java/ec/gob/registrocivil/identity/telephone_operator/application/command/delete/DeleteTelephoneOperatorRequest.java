package ec.gob.registrocivil.identity.telephone_operator.application.command.delete;

import java.util.UUID;

public class DeleteTelephoneOperatorRequest {

    private UUID id;

    public DeleteTelephoneOperatorRequest(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
