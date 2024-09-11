package cloud.tteams.identity.security.application.refresh;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public record RefreshQuery(String jwtToken) implements IQuery {

}
