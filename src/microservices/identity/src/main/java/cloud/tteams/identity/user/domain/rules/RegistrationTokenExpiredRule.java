package cloud.tteams.identity.user.domain.rules;

import java.time.LocalDateTime;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.RegistrationToken;

public class RegistrationTokenExpiredRule extends BusinessRule {

    private final RegistrationToken registrationToken;

    private final LocalDateTime currentDateTime;

    public RegistrationTokenExpiredRule(RegistrationToken registrationToken,
            LocalDateTime currentDateTime) {
        super("Registration Token is expired!");
        this.registrationToken = registrationToken;
        this.currentDateTime = currentDateTime;
    }

    @Override
    public boolean isBroken() {
        return registrationToken.getEndingDateTime().isBefore(this.currentDateTime);
    }
}
