package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserFirstName;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserFirstNameRequiredRule extends BusinessRule {

    private UserFirstName firstName;

    public UserFirstNameRequiredRule(UserFirstName firstName) {
        super(DomainErrorMessage.USER_FIRST_NAME_REQUIRED, "User first name is required!");
        this.firstName = firstName;
    }

    @Override
    public boolean isBroken() {
        return null == firstName || firstName.value().isBlank();
    }
}
