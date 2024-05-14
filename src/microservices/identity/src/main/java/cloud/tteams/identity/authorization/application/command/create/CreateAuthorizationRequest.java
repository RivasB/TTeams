package cloud.tteams.identity.authorization.application.command.create;

import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateAuthorizationRequest {

    @NotNull @NotBlank
    private final String name;

    @NotNull @NotBlank
    private final String resource;

    @NotNull
    private final AuthorizedAction action;

    public CreateAuthorizationRequest(String name, String resource, AuthorizedAction action) {
        this.name = name;
        this.resource = resource;
        this.action = action;
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
}
