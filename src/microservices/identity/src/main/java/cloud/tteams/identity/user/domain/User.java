package cloud.tteams.identity.user.domain;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.AggregateRoot;

import java.util.Optional;
import java.util.UUID;

public final class User extends AggregateRoot<User> {

    private final UUID id;

    private String firstName;

    private String lastName;

    private String identification;

    private String email;

    private String password;

    private UserType type;

    private UserState state;

    private Profile profile;

    private RegistrationTokenState registrationState;

    private String phone;

    private Boolean shouldChangePassword;

    private Boolean deleted;

    public User(UUID id, String firstName, String lastName, String identification, String email, String password, UserType type, UserState state, Profile profile, RegistrationTokenState registrationState, String phone, Boolean shouldChangePassword) {
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
        this.shouldChangePassword = shouldChangePassword;
    }

    @Override
    public void update(User user) {
        Optional.ofNullable(user.getFirstName()).ifPresent(value ->
                this.firstName = value);
        Optional.ofNullable(user.getLastName()).ifPresent(value ->
                this.lastName = value);
        Optional.ofNullable(user.getIdentification()).ifPresent(value ->
                this.identification = value);
        Optional.ofNullable(user.getEmail()).ifPresent(value ->
                this.email = value);
        Optional.ofNullable(user.getPassword()).ifPresent(value ->
                this.password = value);
        Optional.ofNullable(user.getType()).ifPresent(value ->
                this.type = value);
        Optional.ofNullable(user.getState()).ifPresent(value ->
                this.state = value);
        Optional.ofNullable(user.getProfile()).ifPresent(value ->
                this.profile = value);
        Optional.ofNullable(user.getRegistrationState()).ifPresent(value ->
                this.registrationState = value);
        Optional.ofNullable(user.getPhone()).ifPresent(value ->
                this.phone = value);
        Optional.ofNullable(user.getShouldChangePassword()).ifPresent(value ->
                this.shouldChangePassword = value);
    }

    public void blockUserByMaxTokenVerificationAttempts(){
        this.registrationState = RegistrationTokenState.VERIFICATION_BLOCKED;
    }

    public void unBlockUserByMaxTokenVerificationAttempts(){
        this.registrationState = RegistrationTokenState.VERIFICATION_ACCEPTED;
    }

    public void setFreshInstallTokenState() {
        this.registrationState = RegistrationTokenState.VERIFICATION_NONE;
    }

    public void updatePassword(String newPassword){
        this.password = newPassword;
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

    public Profile getProfile() {
        return profile;
    }

    public RegistrationTokenState getRegistrationState() {
        return registrationState;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getShouldChangePassword() {
        return shouldChangePassword;
    }

    public Boolean getDeleted() {
        return deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
