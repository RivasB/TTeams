package cloud.tteams.identity.user.infrastructure.repository.hibernate;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileDto;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.infrastructure.repository.hibernate.TelephoneOperatorDto;
import cloud.tteams.identity.user.domain.*;
import cloud.tteams.identity.user.domain.*;
import jakarta.persistence.*;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "jpa_user")
@Where(clause = "deleted = false")
public class UserDto {

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

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "jpa_mtm_user_profile",
            joinColumns = @JoinColumn(name = "fk_pk_user"),
            inverseJoinColumns = @JoinColumn(name = "fk_pk_profile"))
    private Set<ProfileDto> profiles;

    @Enumerated(EnumType.STRING)
    @Column(name = "registration_state")
    private RegistrationTokenState registrationState;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "telephone_operator_id", referencedColumnName = "id")
    private TelephoneOperatorDto telephoneOperator;

    @Column(name = "change_password")
    private Boolean shouldChangePassword;

    @Column(name = "deleted")
    private Boolean deleted;

    public UserDto() {
    }

    public UserDto(UUID id, String firstName, String lastName, String identification, String email,
            String password, UserType type, UserState state, RegistrationTokenState registrationState, String phone,
            TelephoneOperatorDto telephoneOperator) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.password = password;
        this.type = type;
        this.state = state;
        this.profiles = new HashSet<>();
        this.registrationState = registrationState;
        this.phone = phone;
        this.telephoneOperator = telephoneOperator;
        this.shouldChangePassword = false;
        this.deleted = false;
    }

    public UserDto(User user) {
        this.id = user.getId().value();
        this.firstName = user.getFirstName() != null ? user.getFirstName().value() : null;
        this.lastName = user.getLastName() != null ? user.getLastName().value() : null;
        this.identification = user.getIdentification().value();
        this.email = user.getEmail().value();
        this.password = user.getPassword().value();
        this.type = user.getType();
        this.state = user.getState();

        this.profiles = new HashSet<>();
        if (user.getProfiles() != null) {
            user.getProfiles().getValue().forEach(element -> profiles.add(new ProfileDto(element)));
        }
        this.registrationState = user.getRegistrationState();

        this.phone = null;
        if (user.getPhone() != null) {
            this.phone = user.getPhone().value();
        }

        if (user.getTelephoneOperator() != null) {
            this.telephoneOperator = new TelephoneOperatorDto(user.getTelephoneOperator());
        }

        this.shouldChangePassword = user.getShouldChangePassword() != null ? user.getShouldChangePassword().value()
                : false;
        this.deleted = user.getDeleted() != null ? user.getDeleted().value() : false;
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

    public RegistrationTokenState getRegistrationState() {
        return registrationState;
    }

    public Set<ProfileDto> getProfiles() {
        return profiles;
    }

    public String getPhone() {
        return phone;
    }

    public TelephoneOperatorDto getTelephoneOperator() {
        return telephoneOperator;
    }

    public Boolean getShouldChangePassword() {
        return shouldChangePassword;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public User toAggregate() {
        UserId uId = new UserId(getId());
        UserFirstName uFirstName = getFirstName() != null ? new UserFirstName(getFirstName()) : null;
        UserLastName uLastName = getLastName() != null ? new UserLastName(getLastName()) : null;
        UserIdentification uIdentification = new UserIdentification(getIdentification());
        UserEmail uEmail = new UserEmail(getEmail());
        UserPassword uPassword = new UserPassword(getPassword());
        UserType uType = getType();
        UserState uState = getState();

        Set<Profile> profileList = new HashSet<>();
        if (getProfiles() != null) {
            profileList = getProfiles().stream().map(ProfileDto::toAggregate).collect(Collectors.toSet());
        }
        UserProfileSet uProfiles = new UserProfileSet(profileList);
        RegistrationTokenState uRegistrationState = getRegistrationState();
        UserPhone uPhone = getPhone() != null ? new UserPhone(getPhone()) : null;
        TelephoneOperator uTelephoneOperator = getTelephoneOperator() != null ? getTelephoneOperator().toAggregate()
                : null;

        UserShouldChangePassword uChangePassword = getShouldChangePassword() != null
                ? new UserShouldChangePassword(getShouldChangePassword())
                : null;

        return new User(uId, uFirstName, uLastName, uIdentification, uEmail, uPassword, uType, uState, uProfiles,
                uRegistrationState, uPhone, uTelephoneOperator, uChangePassword);
    }

}
