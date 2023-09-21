package cloud.tteams.identity.user.application;

import cloud.tteams.identity.profile.application.ProfileResponse;
import cloud.tteams.identity.user.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserResponse {

    private final UUID id;

    private final String firstName;

    private final String lastName;

    private final String identification;

    private final String email;

    private final String phone;

    private final String type;

    private final String state;

    private final List<ProfileResponse> profile;

    public UserResponse(User user) {
        this.id = user.getId().value();
        this.firstName = user.getFirstName().value();
        this.lastName = user.getLastName().value();
        this.identification = user.getIdentification().value();
        this.email = user.getEmail().value();
        this.phone = user.getPhone().value();
        this.type = user.getType().toString();
        this.state = user.getState().toString();

        this.profile = new ArrayList<>();
        if (user.getProfiles() != null) {
            user.getProfiles().getValue().stream()
                    .forEach(element -> profile.add(new ProfileResponse(element)));
        }
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

    public String getPhone() {
        return phone;
    }

    public String getType() {
        return type;
    }

    public String getState() {
        return state;
    }

    public List<ProfileResponse> getProfile() {
        return profile;
    }

}
