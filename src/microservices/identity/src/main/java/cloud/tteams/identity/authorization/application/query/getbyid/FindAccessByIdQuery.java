package cloud.tteams.identity.authorization.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindAccessByIdQuery implements IQuery {

    private UUID id;

    public FindAccessByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
