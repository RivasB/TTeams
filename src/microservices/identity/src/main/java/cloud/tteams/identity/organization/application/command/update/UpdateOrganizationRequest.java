package cloud.tteams.identity.organization.application.command.update;

import cloud.tteams.share.core.domain.State;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateOrganizationRequest(@NotNull UUID id, String name, String description, String contact,
                                        State state) {

    public UpdateOrganizationRequest(UUID id, String name, String description, String contact, State state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.state = state;
    }

    @Override
    public UUID id() {
        return id;
    }
}
