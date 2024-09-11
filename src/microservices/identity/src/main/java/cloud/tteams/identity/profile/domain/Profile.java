package cloud.tteams.identity.profile.domain;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.share.core.domain.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Profile {

    private final UUID id;

    private String name;

    private String description;

    private Organization organization;

    private State state;

    private List<Authorization> authorizations;

    private List<User> users;

    public Profile(UUID id, String name, String description, Organization organization, State state, List<Authorization> authorizations, List<User> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organization = organization;
        this.state = state;
        this.authorizations = authorizations;
        this.users = users;
    }

    public Profile(UUID id, String name, String description, Organization organization, State state, List<Authorization> authorizations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.organization = organization;
        this.state = state;
        this.authorizations = authorizations;
        this.users = new ArrayList<>();
    }

    public void update(Profile profile){
        Optional.ofNullable(profile.getName()).ifPresent(value ->
                this.name = value );
        Optional.ofNullable(profile.getDescription()).ifPresent(value ->
                this.description = value );
        Optional.ofNullable(profile.getOrganization()).ifPresent(value ->
                this.organization = value );
        Optional.ofNullable(profile.getState()).ifPresent(value ->
                this.state = value );
        Optional.ofNullable(profile.getAuthorizations()).ifPresent(value ->
                this.authorizations = value );
        Optional.ofNullable(profile.getUsers()).ifPresent(value ->
                this.users = value );
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

    public Organization getOrganization() {return organization;}

    public State getState() {
        return state;
    }

    public List<Authorization> getAuthorizations() {
        return authorizations;
    }

    public List<User> getUsers() {
        return users;
    }
}
