package cloud.tteams.identity.profile.application.command.create;

import java.util.Collection;
import java.util.UUID;

import cloud.tteams.identity.profile.domain.ProfileState;

public class CreateProfileRequest {

    private String name;

    private String description;

    private UUID agency;

    private ProfileState state;

    private Collection<UUID> access;

    public CreateProfileRequest(String name, String description, UUID agency, ProfileState state,
            Collection<UUID> access) {
        this.name = name;
        this.description = description;
        this.agency = agency;
        this.state = state;
        this.access = access;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getAgency() {
        return agency;
    }

    public ProfileState getState() {
        return state;
    }

    public Collection<UUID> getAccess() {
        return access;
    }
}
