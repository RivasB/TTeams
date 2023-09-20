package ec.gob.registrocivil.identity.aplication.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindApplicationByIdQuery implements IQuery {

    private UUID id;

    public FindApplicationByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
