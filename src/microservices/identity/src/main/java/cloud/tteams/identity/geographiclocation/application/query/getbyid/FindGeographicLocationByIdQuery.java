package cloud.tteams.identity.geographiclocation.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindGeographicLocationByIdQuery implements IQuery {

    private UUID id;

    public FindGeographicLocationByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
