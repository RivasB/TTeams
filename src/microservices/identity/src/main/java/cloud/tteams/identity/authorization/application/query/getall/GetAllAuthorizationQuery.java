package cloud.tteams.identity.authorization.application.query.getall;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

public record GetAllAuthorizationQuery(Pageable pageable, String name, String resource, AuthorizedAction action,
                                       State state) implements IQuery {

}
