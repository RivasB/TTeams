package cloud.tteams.share.user.infrastructure.repository.hibernate;



import cloud.tteams.share.user.domain.*;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "jpa_user")
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
    
    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private UserState state;
    
    public UserDto() {
    }

    public UserDto(UUID id, String firstName, String lastName, String identification, String email, String phone, UserState state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identification = identification;
        this.email = email;
        this.phone = phone;
        this.state = state;
    }

    public UserDto(User user) {
        this.id = user.getId().value();
        this.firstName = user.getFirstName() != null ? user.getFirstName().value() : null;
        this.lastName = user.getLastName() != null ? user.getLastName().value() : null;
        this.identification = user.getIdentification().value();
        this.email = user.getEmail().value();
        this.state = user.getState();
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

    public UserState getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public User toAggregate() {
        UserId uId = new UserId(getId());
        UserFirstName uFirstName = getFirstName() != null ? new UserFirstName(getFirstName()) : null;
        UserLastName uLastName = getLastName() != null ? new UserLastName(getLastName()) : null;
        UserIdentification uIdentification = new UserIdentification(getIdentification());
        UserEmail uEmail = new UserEmail(getEmail());
        UserState uState = getState();
        UserPhone uPhone = new UserPhone(getPhone());
        return new User(
                uId, 
                uFirstName, 
                uLastName, 
                uIdentification, 
                uEmail,
                uPhone,
                uState
        );
    }
}
