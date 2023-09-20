package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserType;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class UserTypeRequiredRule extends BusinessRule {

    private UserType type;

    public UserTypeRequiredRule(UserType type) {
        super(DomainErrorMessage.USER_TYPE_REQUIRED, "User type is required!");

        this.type = type;
    }

    @Override
    public boolean isBroken() {
        return null == type;
    }
}
