package cloud.tteams.identity.authorization.domain.rules;

import cloud.tteams.identity.authorization.domain.AccessCode;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class AccessCodeMustBeRequiredRule extends BusinessRule {

    private AccessCode code;

    public AccessCodeMustBeRequiredRule(AccessCode code) {
        super(DomainErrorMessage.ACCESS_CODE_REQUIRED, "Access code is required!");

        this.code = code;
    }

    @Override
    public boolean isBroken() {
        return null == code;
    }
}
