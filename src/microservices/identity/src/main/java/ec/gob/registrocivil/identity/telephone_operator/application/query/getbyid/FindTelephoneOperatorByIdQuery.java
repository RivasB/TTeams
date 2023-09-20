package ec.gob.registrocivil.identity.telephone_operator.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindTelephoneOperatorByIdQuery implements IQuery {

    private UUID id;

    public FindTelephoneOperatorByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
