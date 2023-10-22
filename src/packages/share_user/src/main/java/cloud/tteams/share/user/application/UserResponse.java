package cloud.tteams.share.user.application;

import cloud.tteams.share.user.domain.User;

import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String identification;
    private String email;
    private String phone;

    public UserResponse(UUID id, String firstName, String lastName, String identification, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
    }

    public UserResponse(User user) {
        this.id = user.getId().value();
        this.firstName = user.getFirstName().value();
        this.lastName = user.getLastName().value();
        this.identification = user.getIdentification().value();
        this.email = user.getEmail().value();
        this.phone = user.getPhone().value();
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
}
