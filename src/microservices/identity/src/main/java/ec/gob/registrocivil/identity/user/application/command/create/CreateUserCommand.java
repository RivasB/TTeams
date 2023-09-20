package ec.gob.registrocivil.identity.user.application.command.create;

import ec.gob.registrocivil.identity.user.domain.RegistrationTokenState;
import ec.gob.registrocivil.identity.user.domain.UserState;
import ec.gob.registrocivil.identity.user.domain.UserType;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommand;
import ec.gob.registrocivil.share.core.domain.bus.command.ICommandMessage;

import java.util.Collection;
import java.util.UUID;

public class CreateUserCommand implements ICommand {

    private UUID id;

    private String firstName;

    private String lastName;

    private String identification;

    private String email;

    private String password;

    private UserType type;

    private UserState state;

    private Collection<String> profile;

    private RegistrationTokenState registrationState;

    private String phone;

    private UUID operator;

    public CreateUserCommand(String firstName, String lastName, String identification, String email, String password,
                             UserType type, UserState state, Collection<String> profile,
                             RegistrationTokenState registrationState, String phone, UUID operator) {
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
        this.operator = operator;
    }

    public static CreateUserCommand fromRequest(CreateUserRequest request) {

        return new CreateUserCommand(
                request.getFirstName(),
                request.getLastName(),
                request.getIdentification(),
                request.getEmail(),
                request.getPassword(),
                request.getType(),
                request.getState(),
                request.getProfile(),
                RegistrationTokenState.VERIFICATION_ACCEPTED,
                request.getPhone(),
                request.getOperator());
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

    public Collection<String> getProfile() {
        return profile;
    }

    public RegistrationTokenState getRegistrationState() {
        return registrationState;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getOperator() {
        return operator;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CreateUserMessage(id);
    }

}
