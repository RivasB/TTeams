package cloud.tteams.identity.authorization.domain;

import cloud.tteams.share.core.domain.AggregateRoot;
import cloud.tteams.share.core.domain.State;

import java.util.Optional;
import java.util.UUID;

public class Authorization extends AggregateRoot<Authorization> {
    private final UUID id;
    private String name;
    private String resource;
    private AuthorizedAction action;
    private State state;

    public Authorization(UUID id, String name, String resource, AuthorizedAction action, State state) {
        this.id = id;
        this.name = name;
        this.resource = resource;
        this.action = action;
        this.state = state;
    }

    @Override
    public void update(Authorization authorization){
        Optional.ofNullable(authorization.getName()).ifPresent(value ->
                this.name = value );
        Optional.ofNullable(authorization.getAction()).ifPresent(value ->
            this.action = value );
        Optional.ofNullable(authorization.getResource()).ifPresent(value ->
                this.resource = value );
        Optional.ofNullable(authorization.getState()).ifPresent(value ->
                this.state = value );
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
