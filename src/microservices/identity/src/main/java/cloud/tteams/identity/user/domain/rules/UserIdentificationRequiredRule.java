package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserIdentification;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserIdentificationRequiredRule extends BusinessRule {

    private UserIdentification identification;

    public UserIdentificationRequiredRule(UserIdentification identification) {
        super(DomainErrorMessage.USER_IDENTIFICATION_REQUIRED, "User identification is required!");

        this.identification = identification;
    }

    @Override
    public boolean isBroken() {
        return null == identification || identification.value().isBlank();
    }
}
