package cloud.tteams.identity.profile.application;

import java.util.List;

import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.State;

public class ProfileResponse {

    private final String id;
    private final String name;
    private final String description;
    private final State state;
    private final OrganizationResponse organization;
    private final List<AuthorizationResponse> authorizations;

    public ProfileResponse(Profile profile) {
        this.id = profile.getId().toString();
        this.name = profile.getName();
        this.description = profile.getDescription();
        this.state = profile.getState();
        this.organization = new OrganizationResponse(profile.getOrganization());
        this.authorizations = profile.getAuthorizations().stream().map(AuthorizationResponse::new).toList();
    }

    public String getId() {
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

    public OrganizationResponse getOrganization() {
        return organization;
    }

    public List<AuthorizationResponse> getAuthorizations() {
        return authorizations;
    }
}
