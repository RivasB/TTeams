package cloud.tteams.identity.user.infrastructure.repository.hibernate;

import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import cloud.tteams.identity.user.domain.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.Objects;
import java.util.Optional;
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

    @Column(name = "identification", unique = true)
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
        Optional.ofNullable(user.getId()).ifPresent(value -> this.id = value);
        Optional.ofNullable(user.getFirstName()).ifPresent(value -> this.firstName = value);
        Optional.ofNullable(user.getLastName()).ifPresent(value -> this.lastName = value);
        Optional.ofNullable(user.getIdentification()).ifPresent(value -> this.identification = value);
        Optional.ofNullable(user.getEmail()).ifPresent(value -> this.email = value);
        Optional.ofNullable(user.getPassword()).ifPresent(value -> this.password = value);
        Optional.ofNullable(user.getType()).ifPresent(value -> this.type = value);
        Optional.ofNullable(user.getState()).ifPresent(value -> this.state = value);
        Optional.ofNullable(user.getProfile()).ifPresent(profile -> this.profile = new ProfileEntity(profile));
        Optional.ofNullable(user.getRegistrationState()).ifPresent(value -> this.registrationState = value);
        Optional.ofNullable(user.getPhone()).ifPresent(value -> this.phone = value);
        this.shouldChangePassword = Optional.ofNullable(user.getShouldChangePassword()).orElse(false);
        this.deleted = Optional.ofNullable(user.getDeleted()).orElse(false);
    }


    public User toAggregate() {
        return new User(this.id, this.firstName, this.lastName, this.identification, this.email, this.password, this.type
        , this.state, Objects.nonNull(this.profile) ? this.profile.toAggregate() : null, this.registrationState, this.phone, this.shouldChangePassword);
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
