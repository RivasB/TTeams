package cloud.tteams.identity.user.application.command.update;

import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;

import java.util.Collection;
import java.util.UUID;

public class UpdateUserRequest {

    private UUID id;

    private String firstName;

    private String lastName;

    private String identification;

    private String email;

    private UserType type;

    private UserState state;

    private Collection<UUID> profile;

    private String phone;

    private UUID operator;

    public UpdateUserRequest(UUID id, String firstName, String lastName, String identification, String email,
                             UserType type, UserState state, Collection<UUID> profile, String phone, UUID operator) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.type = type;
        this.state = state;
        this.profile = profile;
        this.phone = phone;
        this.operator = operator;
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

    public UserType getType() {
        return type;
    }

    public UserState getState() {
        return state;
    }

    public Collection<UUID> getProfile() {
        return profile;
    }

    public String getPhone() {
        return phone;
    }

    public UUID getOperator() {
        return operator;
    }

}
