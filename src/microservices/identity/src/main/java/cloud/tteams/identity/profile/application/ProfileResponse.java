package cloud.tteams.identity.profile.application;

import java.util.List;

import cloud.tteams.identity.authorization.application.AuthorizationResponse;
import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import cloud.tteams.identity.profile.domain.Profile;

public class ProfileResponse {

    private String id;
    private String name;
    private String description;
    private ProfileState state;
    private OrganizationResponse agency;
    private List<AuthorizationResponse> access;

    public ProfileResponse(Profile profile) {
        this.id = profile.getId().getValue().toString();
        this.name = profile.getName().getValue();
        this.description = profile.getDescription().getValue();
        this.state = profile.getState();
        this.agency = new OrganizationResponse(profile.getAgency());
        this.access = profile.getAccess().getValue().stream().map(item -> {
            return new AuthorizationResponse(item);
        }).toList();
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

    public ProfileState getState() {
        return state;
    }

    public OrganizationResponse getAgency() {
        return agency;
    }

    public List<AuthorizationResponse> getAccess() {
        return access;
    }
}
