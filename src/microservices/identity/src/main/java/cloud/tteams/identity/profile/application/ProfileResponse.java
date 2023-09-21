package cloud.tteams.identity.profile.application;

import java.util.List;

import cloud.tteams.identity.access.application.AccessResponse;
import cloud.tteams.identity.agency.application.query.AgencyResponse;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.ProfileState;

public class ProfileResponse {

    private String id;
    private String name;
    private String description;
    private ProfileState state;
    private AgencyResponse agency;
    private List<AccessResponse> access;

    public ProfileResponse(Profile profile) {
        this.id = profile.getId().getValue().toString();
        this.name = profile.getName().getValue();
        this.description = profile.getDescription().getValue();
        this.state = profile.getState();
        this.agency = new AgencyResponse(profile.getAgency());
        this.access = profile.getAccess().getValue().stream().map(item -> {
            return new AccessResponse(item);
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

    public AgencyResponse getAgency() {
        return agency;
    }

    public List<AccessResponse> getAccess() {
        return access;
    }
}
