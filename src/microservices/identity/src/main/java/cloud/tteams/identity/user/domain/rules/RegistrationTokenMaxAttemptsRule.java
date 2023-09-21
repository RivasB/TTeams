package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.RegistrationToken;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class RegistrationTokenMaxAttemptsRule extends BusinessRule {

    private RegistrationToken registrationToken;

    private int maxAttempts;

    public RegistrationTokenMaxAttemptsRule(RegistrationToken registrationToken, int maxAttempts) {
        super(DomainErrorMessage.REGISTRATION_TOKEN_MAX_ATTEMPTS_REACHED,
                "Registration Token max number of attempts reached!");
        this.registrationToken = registrationToken;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public boolean isBroken() {
        return registrationToken.getAttempts().value() + 1 > this.maxAttempts;
    }
}
