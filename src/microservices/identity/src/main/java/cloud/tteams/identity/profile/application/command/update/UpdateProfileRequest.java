package cloud.tteams.identity.profile.application.command.update;

import cloud.tteams.share.core.domain.State;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.UUID;

public record UpdateProfileRequest(@NotNull UUID id, String name, String description, State state, UUID organization,
                                   Collection<UUID> authorizations) {

    public UpdateProfileRequest(UUID id, String name, String description, State state, UUID organization,
                                Collection<UUID> authorizations) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.organization = organization;
        this.authorizations = authorizations;
    }

    @Override
    public UUID id() {
        return id;
    }

}
