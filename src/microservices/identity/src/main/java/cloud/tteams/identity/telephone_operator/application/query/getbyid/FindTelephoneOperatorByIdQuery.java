package cloud.tteams.identity.telephone_operator.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindTelephoneOperatorByIdQuery implements IQuery {

    private UUID id;

    public FindTelephoneOperatorByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
