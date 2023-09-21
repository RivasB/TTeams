package cloud.tteams.identity.user.domain.rules;

import java.time.LocalDateTime;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class RegistrationTokenExpiredRule extends BusinessRule {

    private RegistrationToken registrationToken;

    private LocalDateTime currentDateTime;

    public RegistrationTokenExpiredRule(RegistrationToken registrationToken,
            LocalDateTime currentDateTime) {
        super(DomainErrorMessage.REGISTRATION_TOKEN_EXPIRED, "Registration Token is expired!");
        this.registrationToken = registrationToken;
        this.currentDateTime = currentDateTime;
    }

    @Override
    public boolean isBroken() {
        return registrationToken.getEndingDateTime().value().isBefore(this.currentDateTime);
    }
}
