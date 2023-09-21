package cloud.tteams.identity.user.application.query.getbyid;

import cloud.tteams.identity.profile.application.ProfileResponse;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.share.core.domain.bus.query.IResponse;

import java.util.List;
import java.util.UUID;

public class FindUserByIdResponse implements IResponse {

    private UUID id;

    private String firstName;

    private String lastName;

    private String identification;

    private String email;
    
    private String phone;

    private UserType type;

    private UserState state;

    private List<ProfileResponse> profile;

    public FindUserByIdResponse(UUID id, String firstName, String lastName, String identification, String email, String phone,
                                UserType type, UserState state, List<ProfileResponse> profile) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.state = state;
        this.profile = profile;
    }

    public FindUserByIdResponse(User user) {
        this.id = user.getId().value();
        this.firstName = user.getFirstName().value();
        this.lastName = user.getLastName().value();
        this.identification = user.getIdentification().value();
        this.email = user.getEmail().value();
        this.phone = user.getPhone().value();
        this.type = user.getType();
        this.state = user.getState();
        this.profile = user.getProfiles().getValue().stream().map(ProfileResponse::new).toList();
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

    public UserType getType() {
        return type;
    }

    public UserState getState() {
        return state;
    }

    public List<ProfileResponse> getProfile() {
        return profile;
    }

}
