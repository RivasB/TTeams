package cloud.tteams.share.user.domain;

public final class User {

    private final UserId id;

    private final UserFirstName firstName;

    private UserLastName lastName;

    private UserIdentification identification;

    private UserEmail email;

    private UserPhone phone;

    private UserState state;

    public User(UserId id, UserFirstName firstName, UserLastName lastName, UserIdentification identification,
                UserEmail email, UserPhone phone, UserState state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.state = state;
    }

    public UserId getId() {
        return id;
    }

    public UserFirstName getFirstName() {
        return firstName;
    }

    public UserLastName getLastName() {
        return lastName;
    }

    public UserIdentification getIdentification() {
        return identification;
    }

    public UserEmail getEmail() {
        return email;
    }

    public UserPhone getPhone() {
        return phone;
    }

    public UserState getState() {
        return state;
    }
}
