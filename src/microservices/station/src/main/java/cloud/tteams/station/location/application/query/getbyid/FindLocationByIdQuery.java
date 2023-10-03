package cloud.tteams.station.location.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class FindLocationByIdQuery implements IQuery {
    private final UUID id;
    public FindLocationByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
