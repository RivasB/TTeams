package cloud.tteams.identity.authorization.application.command.update;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.domain.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class UpdateAuthorizationRequest {

    @NotNull @NotBlank
    private final UUID id;

    @NotBlank
    private final String name;

    @NotBlank
    private final String resource;

    private final AuthorizedAction action;

    private final State state;

    public UpdateAuthorizationRequest(UUID id, String name, String resource, AuthorizedAction action, State state) {
        this.id = id;
        this.name = name;
        this.resource = resource;
        this.action = action;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResource() {
        return resource;
    }

    public AuthorizedAction getAction() {
        return action;
    }

    public State getState() {
        return state;
    }
}
