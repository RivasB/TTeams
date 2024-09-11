package cloud.tteams.identity.user.application.command.create;

import cloud.tteams.identity.user.domain.RegistrationTokenState;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;

import java.util.UUID;

public class CreateUserCommand implements ICommand {

    private final UUID id;

    private final String firstName;

    private final String lastName;

    private final String identification;

    private final String email;

    private final String password;

    private final UserType type;

    private final UserState state;

    private final UUID profile;

    private final RegistrationTokenState registrationState;

    private final String phone;

    public CreateUserCommand(String firstName, String lastName, String identification, String email, String password,
                             UserType type, UserState state, UUID profile,
                             RegistrationTokenState registrationState, String phone) {
        this.id = UUID.randomUUID();
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

    public static CreateUserCommand fromRequest(CreateUserRequest request) {

        return new CreateUserCommand(
                request.firstName(),
                request.lastName(),
                request.identification(),
                request.email(),
                request.password(),
                request.type(),
                request.state(),
                request.profile(),
                RegistrationTokenState.VERIFICATION_ACCEPTED,
                request.phone());
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdentification() {
        return identification;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public UserState getState() {
        return state;
    }

    public UUID getProfile() {
        return profile;
    }

    public RegistrationTokenState getRegistrationState() {
        return registrationState;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateUserMessage(id);
    }
}
