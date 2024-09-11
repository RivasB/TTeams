package cloud.tteams.identity.authorization.application.command.create;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAuthorizationRequest(@NotNull @NotBlank String name, @NotNull @NotBlank String resource,
                                         @NotNull AuthorizedAction action) {

    public CreateAuthorizationRequest(String name, String resource, AuthorizedAction action) {
        this.name = name;
        this.resource = resource;
        this.action = action;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String resource() {
        return resource;
    }

    @Override
    public AuthorizedAction action() {
        return action;
    }
}
