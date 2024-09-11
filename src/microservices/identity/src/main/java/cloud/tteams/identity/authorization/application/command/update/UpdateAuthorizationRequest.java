package cloud.tteams.identity.authorization.application.command.update;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.domain.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateAuthorizationRequest(@NotNull @NotBlank UUID id, String name, String resource,
                                         AuthorizedAction action, State state) {

    public UpdateAuthorizationRequest(UUID id, String name, String resource, AuthorizedAction action, State state) {
        this.id = id;
        this.name = name;
        this.resource = resource;
        this.action = action;
        this.state = state;
    }

    @Override
    public UUID id() {
        return id;
    }
}
