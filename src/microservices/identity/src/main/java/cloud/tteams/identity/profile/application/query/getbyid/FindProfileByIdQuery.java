package cloud.tteams.identity.profile.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindProfileByIdQuery implements IQuery {

    private UUID id;

    public FindProfileByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
