package ec.gob.registrocivil.identity.user.domain;

public class RegistrationToken {

    private final RegistrationTokenId id;

    private final User user;

    private RegistrationTokenOTP otp;

    private RegistrationTokenAttempt attempts;

    private RegistrationTokenDateTime initialDateTime;

    private RegistrationTokenDateTime endingDateTime;

    public RegistrationToken(RegistrationTokenId id, User user, RegistrationTokenOTP otp,
            RegistrationTokenAttempt attempts, RegistrationTokenDateTime initialDateTime,
            RegistrationTokenDateTime endingDateTime) {
        this.id = id;
        this.user = user;
        this.otp = otp;
        this.attempts = attempts;
        this.initialDateTime = initialDateTime;
        this.endingDateTime = endingDateTime;
    }

    public RegistrationTokenId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public RegistrationTokenOTP getOtp() {
        return otp;
    }

    public RegistrationTokenAttempt getAttempts() {
        return attempts;
    }

    public RegistrationTokenDateTime getInitialDateTime() {
        return initialDateTime;
    }

    public RegistrationTokenDateTime getEndingDateTime() {
        return endingDateTime;
    }
}
