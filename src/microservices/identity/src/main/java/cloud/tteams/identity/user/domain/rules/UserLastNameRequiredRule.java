package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserLastName;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserLastNameRequiredRule extends BusinessRule {

    private UserLastName lastName;

    public UserLastNameRequiredRule(UserLastName lastName) {
        super(DomainErrorMessage.USER_LAST_NAME_REQUIRED, "User last name is required!");
        this.lastName = lastName;
    }

    @Override
    public boolean isBroken() {
        return null == lastName || lastName.value().isBlank();
    }

}
