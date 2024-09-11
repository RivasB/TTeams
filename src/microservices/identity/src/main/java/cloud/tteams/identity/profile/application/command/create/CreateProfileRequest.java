package cloud.tteams.identity.profile.application.command.create;

import cloud.tteams.share.core.domain.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.UUID;

public record CreateProfileRequest(@NotBlank String name, String description, @NotNull UUID organization, State state,
                                   @NotEmpty Collection<UUID> authorizations) {

}
