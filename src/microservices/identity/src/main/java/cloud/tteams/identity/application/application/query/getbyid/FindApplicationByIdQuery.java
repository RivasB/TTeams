package cloud.tteams.identity.application.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindApplicationByIdQuery implements IQuery {

    private UUID id;

    public FindApplicationByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
