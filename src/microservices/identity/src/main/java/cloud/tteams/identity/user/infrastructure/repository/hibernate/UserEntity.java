package cloud.tteams.identity.user.infrastructure.repository.hibernate;

import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import cloud.tteams.identity.user.domain.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.UUID;

@Entity
@Table(name = "tteams_user")
@Where(clause = "deleted = false")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identification", unique = true, nullable = false)
    private String identification;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private UserState state;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pk_profile")
    private ProfileEntity profile;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_state")
    private RegistrationTokenState registrationState;

    @Column(name = "phone")
    private String phone;

    @Column(name = "change_password")
    private Boolean shouldChangePassword;

    @Column(name = "deleted")
    private Boolean deleted;

    public UserEntity() {
    }

    public UserEntity(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.identification = user.getIdentification();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.type = user.getType();
        this.state = user.getState();
        this.profile =  new ProfileEntity(user.getProfile());
        this.registrationState = user.getRegistrationState();
        this.phone = user.getPhone();
        this.shouldChangePassword = user.getShouldChangePassword() != null ? user.getShouldChangePassword()
                : false;
        this.deleted = user.getDeleted() != null ? user.getDeleted() : false;
    }


    public User toAggregate() {
        return new User(this.id, this.firstName, this.lastName, this.identification, this.email, this.password, this.type
        , this.state, this.profile.toAggregate(), this.registrationState, this.phone, this.shouldChangePassword);
    }

    public void removeProfile(){
        this.profile = null;
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

    public ProfileEntity getProfile() {
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
}
