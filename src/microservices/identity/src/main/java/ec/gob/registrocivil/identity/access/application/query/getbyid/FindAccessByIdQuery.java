package ec.gob.registrocivil.identity.access.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindAccessByIdQuery implements IQuery {

    private UUID id;

    public FindAccessByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
