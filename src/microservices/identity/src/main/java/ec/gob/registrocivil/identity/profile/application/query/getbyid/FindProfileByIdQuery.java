package ec.gob.registrocivil.identity.profile.application.query.getbyid;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindProfileByIdQuery implements IQuery {

    private UUID id;

    public FindProfileByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
