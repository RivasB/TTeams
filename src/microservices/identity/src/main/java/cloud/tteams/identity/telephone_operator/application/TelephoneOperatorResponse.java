package cloud.tteams.identity.telephone_operator.application;

import java.util.UUID;

import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorName;

public class TelephoneOperatorResponse {

    private UUID id;

    private String name;

    public TelephoneOperatorResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public TelephoneOperatorResponse(TelephoneOperatorId id, TelephoneOperatorName name) {
        this.id = id.value();
        this.name = name.value();
    }

    public TelephoneOperatorResponse(TelephoneOperator operator) {
        this.id = operator.getId().value();
        this.name = operator.getName().value();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
