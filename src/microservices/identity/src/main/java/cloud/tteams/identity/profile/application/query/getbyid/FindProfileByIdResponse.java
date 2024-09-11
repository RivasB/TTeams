package cloud.tteams.identity.profile.application.query.getbyid;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindProfileByIdResponse implements IResponse {

    private final UUID id;

    private final String name;

    private final String description;

    private final State state;

    private final OrganizationResponse organization;

    private final Collection<AuthorizationResponse> authorizations;

    public FindProfileByIdResponse(Profile profile) {
        this.id = profile.getId();
        this.name = profile.getName();
        this.description = profile.getDescription();
        this.state = profile.getState();
        this.organization = new OrganizationResponse(profile.getOrganization());
        this.authorizations = profile.getAuthorizations().stream().map(AuthorizationResponse::new).toList();
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

    public OrganizationResponse getOrganization() {
        return organization;
    }

    public Collection<AuthorizationResponse> getAuthorizations() {
        return authorizations;
    }
}
