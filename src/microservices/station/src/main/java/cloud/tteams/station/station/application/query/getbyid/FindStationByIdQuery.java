package cloud.tteams.station.station.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class FindStationByIdQuery implements IQuery {

    private final UUID id;

    public FindStationByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
