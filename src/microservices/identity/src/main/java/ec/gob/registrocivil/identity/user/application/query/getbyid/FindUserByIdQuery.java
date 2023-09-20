package ec.gob.registrocivil.identity.user.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindUserByIdQuery implements IQuery {

    private UUID id;

    public FindUserByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
