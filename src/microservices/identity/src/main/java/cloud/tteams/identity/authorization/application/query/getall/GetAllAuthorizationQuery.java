package cloud.tteams.identity.authorization.application.query.getall;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.query.IQuery;
import org.springframework.data.domain.Pageable;

public class GetAllAuthorizationQuery implements IQuery {

    private Pageable pageable;

    private String name;

    private String resource;

    private AuthorizedAction action;

    private State state;

    public GetAllAuthorizationQuery(Pageable pageable, String name, String resource, AuthorizedAction action, State state) {
        this.pageable = pageable;
        this.name = name;
        this.resource = resource;
        this.action = action;
        this.state = state;
    }

    public Pageable getPageable() {
        return pageable;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public AuthorizedAction getAction() {
        return action;
    }

    public State getState() {
        return state;
    }
}
