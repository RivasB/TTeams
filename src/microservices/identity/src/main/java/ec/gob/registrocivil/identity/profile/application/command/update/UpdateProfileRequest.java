package ec.gob.registrocivil.identity.profile.application.command.update;

import java.util.Collection;
import java.util.UUID;

import ec.gob.registrocivil.identity.profile.domain.ProfileState;

public class UpdateProfileRequest {

    private UUID id;

    private String name;

    private String description;

    private ProfileState state;

    private UUID agency;

    private Collection<UUID> access;

    public UpdateProfileRequest(UUID id, String name, String description, ProfileState state, UUID agency,
            Collection<UUID> access) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.agency = agency;
        this.access = access;
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

    public UUID getAgency() {
        return agency;
    }

    public Collection<UUID> getAccess() {
        return access;
    }

}
