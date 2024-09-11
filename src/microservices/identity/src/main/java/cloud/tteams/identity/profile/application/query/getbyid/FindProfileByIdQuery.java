package cloud.tteams.identity.profile.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record FindProfileByIdQuery(UUID id) implements IQuery {

}
