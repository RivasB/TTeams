package cloud.tteams.identity.profile.domain;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.share.core.domain.State;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Profile {
    private final UUID id;
    private String name;
    private String description;
    private State state;
    private List<Authorization> authorizations;

    public Profile(UUID id, String name, String description, State state, List<Authorization> authorizations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.authorizations = authorizations;
    }

    public void update(Profile profile){
        Optional.ofNullable(profile.getName()).ifPresent(value ->
                this.name = value );
        Optional.ofNullable(profile.getDescription()).ifPresent(value ->
                this.description = value );
        Optional.ofNullable(profile.getState()).ifPresent(value ->
                this.state = value );
        Optional.ofNullable(profile.getAuthorizations()).ifPresent(value ->
                this.authorizations = value );
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public State getState() {
        return state;
    }

    public List<Authorization> getAuthorizations() {
        return authorizations;
    }
}
