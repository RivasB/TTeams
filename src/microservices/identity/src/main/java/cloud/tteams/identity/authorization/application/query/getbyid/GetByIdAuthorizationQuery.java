package cloud.tteams.identity.authorization.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record GetByIdAuthorizationQuery(UUID id) implements IQuery {

}
