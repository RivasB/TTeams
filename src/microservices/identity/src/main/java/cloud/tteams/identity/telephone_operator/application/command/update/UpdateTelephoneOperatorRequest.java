package cloud.tteams.identity.telephone_operator.application.command.update;

import java.util.UUID;

public class UpdateTelephoneOperatorRequest {

    private UUID id;

    private String name;

    public UpdateTelephoneOperatorRequest(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
