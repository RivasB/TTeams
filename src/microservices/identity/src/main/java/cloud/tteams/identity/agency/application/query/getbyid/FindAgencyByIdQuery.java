package cloud.tteams.identity.agency.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindAgencyByIdQuery implements IQuery {

    private UUID id;

    public FindAgencyByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
