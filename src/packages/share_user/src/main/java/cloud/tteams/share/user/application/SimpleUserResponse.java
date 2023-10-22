package cloud.tteams.share.user.application;

import cloud.tteams.share.user.domain.User;

import java.util.UUID;

public class SimpleUserResponse {
    private UUID id;
    private String firstName;
    private String lastName;

    public SimpleUserResponse(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SimpleUserResponse(User user) {
        this.id = user.getId().value();
        this.firstName = user.getFirstName().value();
        this.lastName = user.getLastName().value();
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
}
