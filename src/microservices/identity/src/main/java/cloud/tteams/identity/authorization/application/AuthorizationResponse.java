package cloud.tteams.identity.authorization.application;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.query.IResponse;

import java.util.UUID;

public class AuthorizationResponse implements IResponse {

    private final UUID id;
    private String name;
    private String resource;
    private AuthorizedAction action;
    private State state;

    public AuthorizationResponse(Authorization authorization) {
        this.id = authorization.getId();
        this.name = authorization.getName();
        this.resource = authorization.getResource();
        this.action = authorization.getAction();
        this.state = authorization.getState();
    }

    public UUID getId() {
        return id;
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
