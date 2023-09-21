package cloud.tteams.identity.user.domain;

import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;

public final class User {

    private final UserId id;

    private final UserFirstName firstName;

    private final UserLastName lastName;

    private final UserIdentification identification;

    private final UserEmail email;

    private final UserPassword password;

    private final UserType type;

    private final UserState state;

    private final UserProfileSet profiles;

    private final RegistrationTokenState registrationState;

    private final UserPhone phone;

    private final TelephoneOperator telephoneOperator;

    private UserShouldChangePassword shouldChangePassword;

    private UserDeleted deleted;

    public User(UserId id, UserFirstName firstName, UserLastName lastName, UserIdentification identification,
                UserEmail email, UserPassword password, UserType type, UserState state, UserProfileSet profiles,
                RegistrationTokenState registrationState, UserPhone phone, TelephoneOperator telephoneOperator) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.type = type;
        this.state = state;
        this.profiles = profiles;
        this.registrationState = registrationState;
        this.phone = phone;
        this.telephoneOperator = telephoneOperator;
        this.deleted = new UserDeleted(false);
    }

    public User(UserId id, UserFirstName firstName, UserLastName lastName, UserIdentification identification,
                UserEmail email, UserPassword password, UserType type, UserState state, UserProfileSet profiles,
                RegistrationTokenState registrationState, UserPhone phone, TelephoneOperator telephoneOperator,
                UserShouldChangePassword shouldChangePassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.type = type;
        this.state = state;
        this.profiles = profiles;
        this.registrationState = registrationState;
        this.phone = phone;
        this.telephoneOperator = telephoneOperator;
        this.shouldChangePassword = shouldChangePassword;
        this.deleted = new UserDeleted(false);
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

    public UserPassword getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public UserState getState() {
        return state;
    }

    public UserProfileSet getProfiles() {
        return profiles;
    }

    public RegistrationTokenState getRegistrationState() {
        return registrationState;
    }

    public UserPhone getPhone() {
        return phone;
    }

    public TelephoneOperator getTelephoneOperator() {
        return telephoneOperator;
    }

    public UserShouldChangePassword getShouldChangePassword() {
        return shouldChangePassword;
    }

    public UserDeleted getDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = new UserDeleted(true);
    }

}
