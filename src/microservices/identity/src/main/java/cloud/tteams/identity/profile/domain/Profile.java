package cloud.tteams.identity.profile.domain;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.user.domain.User;

public class Profile {
    private ProfileId id;
    private ProfileName name;
    private ProfileDescription description;
    private ProfileState state;
    private ProfileAccessSet access;
    private Organization organization;
    private User user;

    public Profile(ProfileId id, ProfileName name, ProfileDescription description, ProfileState state,
                   Organization organization, User user, ProfileAccessSet access) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.organization = organization;
        this.user = user;
        this.access = access;
    }

    public ProfileId getId() {
        return id;
    }

    public ProfileName getName() {
        return name;
    }

    public ProfileDescription getDescription() {
        return description;
    }

    public ProfileState getState() {
        return state;
    }

    public Organization getAgency() {
        return organization;
    }

    public User getUser() {
        return user;
    }

    public ProfileAccessSet getAccess() {
        return access;
    }
}
