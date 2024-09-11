package cloud.tteams.identity.user.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record FindUserByIdQuery(UUID id) implements IQuery {

}
