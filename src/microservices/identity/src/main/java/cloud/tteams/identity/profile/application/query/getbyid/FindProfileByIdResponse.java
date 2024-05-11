package cloud.tteams.identity.profile.application.query.getbyid;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.identity.authorization.application.AccessResponse;
import cloud.tteams.identity.organization.application.query.OrganizationResponse;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.ProfileState;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindProfileByIdResponse implements IResponse {

    private UUID id;

    private String name;

    private String description;

    private ProfileState state;

    private OrganizationResponse agency;

    private Collection<AccessResponse> access;

    public FindProfileByIdResponse(UUID id, String name, String description, ProfileState state, OrganizationResponse agency,
            Collection<AccessResponse> access) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.agency = agency;
        this.access = access;
    }

    public FindProfileByIdResponse(Profile profile) {
        this.id = profile.getId().value();
        this.name = profile.getName().value();
        this.description = profile.getDescription().value();
        this.state = profile.getState();
        this.agency = new OrganizationResponse(profile.getAgency());
        this.access = profile.getAccess().getValue().stream().map(AccessResponse::new).toList();
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

    public ProfileState getState() {
        return state;
    }

    public OrganizationResponse getAgency() {
        return agency;
    }

    public Collection<AccessResponse> getAccess() {
        return access;
    }

}
