package cloud.tteams.identity.user.infrastructure.repository.hibernate;

import java.time.LocalDateTime;
import java.util.UUID;

import cloud.tteams.identity.user.domain.RegistrationToken;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tteams_user_registration_token")
public class RegistrationTokenEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(optional = false)
    @MapsId
    private UserEntity user;

    @Column(unique = true, nullable = false)
    private String otp;

    @Column(nullable = false)
    private Integer attempts;

    @Column(nullable = false)
    private LocalDateTime initialDateTime;

    @Column(nullable = false)
    private LocalDateTime endingDateTime;

    public RegistrationTokenEntity() {
    }

    public RegistrationTokenEntity(RegistrationToken registrationToken) {
        this.id = registrationToken.getId();
        this.user = new UserEntity(registrationToken.getUser());
        this.otp = registrationToken.getOtp();
        this.attempts = registrationToken.getAttempts();
        this.initialDateTime = registrationToken.getInitialDateTime();
        this.endingDateTime = registrationToken.getEndingDateTime();
    }

    public RegistrationToken toAggregate() {
        return new RegistrationToken(this.id, this.user.toAggregate(), this.otp,
                this.attempts, this.initialDateTime, this.endingDateTime);
    }

    public UUID getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getOtp() {
        return otp;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public LocalDateTime getInitialDateTime() {
        return initialDateTime;
    }

    public LocalDateTime getEndingDateTime() {
        return endingDateTime;
    }
}
