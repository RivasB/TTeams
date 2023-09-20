package ec.gob.registrocivil.identity.agency.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindAgencyByIdQuery implements IQuery {

    private UUID id;

    public FindAgencyByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
