package cloud.tteams.identity.user.application;

import cloud.tteams.identity.profile.application.ProfileResponse;
import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.share.core.domain.bus.query.IResponse;

import java.util.Optional;
import java.util.UUID;

public class UserResponse implements IResponse {

    private final UUID id;

    private final String firstName;

    private final String lastName;

    private final String email;

    private final String phone;

    private final String type;

    private final String state;

    private ProfileResponse profile;

    public UserResponse(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.type = user.getType().toString();
        this.state = user.getState().toString();
        Optional.ofNullable(user.getProfile()).ifPresent(profile -> this.profile = new ProfileResponse(profile));
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

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public ProfileResponse getProfile() {
        return profile;
    }
}
