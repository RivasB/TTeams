package ec.gob.registrocivil.identity.user.application.command.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import ec.gob.registrocivil.identity.user.domain.UserState;
import ec.gob.registrocivil.identity.user.domain.UserType;

import java.util.Collection;
import java.util.UUID;

public class CreateUserRequest {

    private String firstName;

    private String lastName;

    private String identification;

    private String email;

    private String password;

    private UserType type;

    private UserState state;

    private Collection<String> profile;

    private String phone;

    private UUID operator;

    @JsonCreator
    public CreateUserRequest(String firstName, String lastName, String identification, String email, String password,
                             UserType type, UserState state, Collection<String> profile, String phone, UUID operator) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.type = type;
        this.state = state;
        this.profile = profile;
        this.phone = phone;
        this.operator = operator;
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

    public String getPhone() {
        return phone;
    }

    public UUID getOperator() {
        return operator;
    }

}
