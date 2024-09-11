package cloud.tteams.identity.user.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class RegistrationToken {

    private final UUID id;

    private final User user;

    private String otp;

    private Integer attempts;

    private LocalDateTime initialDateTime;

    private LocalDateTime endingDateTime;

    public RegistrationToken(UUID id, User user, String otp, Integer attempts, LocalDateTime initialDateTime, LocalDateTime endingDateTime) {
        this.id = id;
        this.user = user;
        this.otp = otp;
        this.attempts = attempts;
        this.initialDateTime = initialDateTime;
        this.endingDateTime = endingDateTime;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public LocalDateTime getInitialDateTime() {
        return initialDateTime;
    }

    public void setInitialDateTime(LocalDateTime initialDateTime) {
        this.initialDateTime = initialDateTime;
    }

    public LocalDateTime getEndingDateTime() {
        return endingDateTime;
    }

    public void setEndingDateTime(LocalDateTime endingDateTime) {
        this.endingDateTime = endingDateTime;
    }
}
