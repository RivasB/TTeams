package cloud.tteams.identity.telephone_operator.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;

public class FindTelephoneOperatorByIdResponse implements IResponse {

    private UUID id;

    private String name;

    public FindTelephoneOperatorByIdResponse(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public FindTelephoneOperatorByIdResponse(TelephoneOperator operator) {
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
