package cloud.tteams.log.log.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class GetLogByIdQuery implements IQuery {

    private final UUID id;

    public GetLogByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
