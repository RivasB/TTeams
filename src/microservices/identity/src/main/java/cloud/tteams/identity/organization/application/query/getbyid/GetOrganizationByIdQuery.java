package cloud.tteams.identity.organization.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record GetOrganizationByIdQuery(UUID id) implements IQuery {

}
