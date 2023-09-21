package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserType;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

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
