package cloud.tteams.station.chargingpoint.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQuery;

import java.util.UUID;

public class FindChargingPointByIdQuery implements IQuery {
    private final UUID id;

    public FindChargingPointByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
