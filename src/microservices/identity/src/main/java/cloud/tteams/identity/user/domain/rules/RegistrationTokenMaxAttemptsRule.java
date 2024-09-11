package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.RegistrationToken;

public class RegistrationTokenMaxAttemptsRule extends BusinessRule {

    private final RegistrationToken registrationToken;

    private final int maxAttempts;

    public RegistrationTokenMaxAttemptsRule(RegistrationToken registrationToken, int maxAttempts) {
        super("Registration Token max number of attempts reached!");
        this.registrationToken = registrationToken;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public boolean isBroken() {
        return registrationToken.getAttempts() + 1 > this.maxAttempts;
    }
}
