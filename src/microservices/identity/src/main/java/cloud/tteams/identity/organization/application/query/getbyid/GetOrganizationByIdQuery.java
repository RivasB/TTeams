package cloud.tteams.identity.organization.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class GetOrganizationByIdQuery implements IQuery {

    private UUID id;

    public GetOrganizationByIdQuery(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
