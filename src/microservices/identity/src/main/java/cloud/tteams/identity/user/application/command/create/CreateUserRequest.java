package cloud.tteams.identity.user.application.command.create;

import cloud.tteams.identity.user.domain.RegistrationTokenState;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateUserRequest(@NotBlank String firstName, @NotBlank String lastName, String identification,
                                @NotBlank String email, @NotBlank String password, @NotNull UserType type,
                                @NotNull UserState state, UUID profile,
                                @NotNull RegistrationTokenState registrationState, String phone) {

}
