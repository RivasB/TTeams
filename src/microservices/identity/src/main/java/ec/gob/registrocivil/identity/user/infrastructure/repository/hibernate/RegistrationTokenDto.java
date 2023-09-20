package ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate;

import java.time.LocalDateTime;
import java.util.UUID;

import ec.gob.registrocivil.identity.user.domain.RegistrationToken;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenAttempt;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenDateTime;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenId;
import ec.gob.registrocivil.identity.user.domain.RegistrationTokenOTP;
import ec.gob.registrocivil.identity.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_user_registration_token")
public class RegistrationTokenDto {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(optional = false)
    @MapsId
    private UserDto user;

    @Column(unique = true, nullable = false)
    private String otp;

    @Column(nullable = false)
    private Integer attempts;

    @Column(nullable = false)
    private LocalDateTime initialDateTime;

    @Column(nullable = false)
    private LocalDateTime endingDateTime;

    public RegistrationTokenDto() {
    }

    public RegistrationTokenDto(UUID id, UserDto user, String otp, Integer attempts, LocalDateTime initialDateTime,
            LocalDateTime endingDateTime) {
        this.id = id;
        this.user = user;
        this.otp = otp;
        this.attempts = attempts;
        this.initialDateTime = initialDateTime;
        this.endingDateTime = endingDateTime;
    }

    public RegistrationTokenDto(RegistrationToken registrationToken) {

        this.id = registrationToken.getId().value();
        this.user = (registrationToken.getUser() != null) ? new UserDto(registrationToken.getUser()) : null;
        this.otp = (registrationToken.getOtp() != null) ? registrationToken.getOtp().value() : null;
        this.attempts = (registrationToken.getAttempts() != null) ? registrationToken.getAttempts().value() : null;
        this.initialDateTime = (registrationToken.getInitialDateTime() != null)
                ? registrationToken.getInitialDateTime().value()
                : null;
        this.endingDateTime = (registrationToken.getEndingDateTime() != null)
                ? registrationToken.getEndingDateTime().value()
                : null;
    }

    public UUID getId() {
        return id;
    }

    public UserDto getUser() {
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

    public RegistrationToken toAggregate() {
        RegistrationTokenId tId = new RegistrationTokenId(this.id);
        User tUser = this.user.toAggregate();
        RegistrationTokenOTP tOtp = new RegistrationTokenOTP(this.otp);
        RegistrationTokenAttempt tAttempt = new RegistrationTokenAttempt(this.attempts);
        RegistrationTokenDateTime tInitialDateTime = new RegistrationTokenDateTime(this.initialDateTime);
        RegistrationTokenDateTime tEndingDateTime = new RegistrationTokenDateTime(this.endingDateTime);

        return new RegistrationToken(tId, tUser, tOtp, tAttempt, tInitialDateTime, tEndingDateTime);
    }
}
