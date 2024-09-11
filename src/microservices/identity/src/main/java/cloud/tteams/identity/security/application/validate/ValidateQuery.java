package cloud.tteams.identity.security.application.validate;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record ValidateQuery(String jwtToken) implements IQuery {

}
