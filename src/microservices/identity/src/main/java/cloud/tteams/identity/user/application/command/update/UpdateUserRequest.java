package cloud.tteams.identity.user.application.command.update;

import cloud.tteams.identity.user.domain.RegistrationTokenState;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateUserRequest(@NotNull UUID id, String firstName, String lastName, String identification,
                                String email, String password, UserType type, UserState state, UUID profile,
                                RegistrationTokenState registrationState, String phone) {

    public UpdateUserRequest(UUID id, String firstName, String lastName, String identification, String email, String password, UserType type, UserState state, UUID profile, RegistrationTokenState registrationState, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.type = type;
        this.state = state;
        this.profile = profile;
        this.registrationState = registrationState;
        this.phone = phone;
    }

    @Override
    public UUID id() {
        return id;
    }
}
