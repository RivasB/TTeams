package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserEmail;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class UserEmailRequiredRule extends BusinessRule {

    private UserEmail email;

    public UserEmailRequiredRule(UserEmail email) {
        super(DomainErrorMessage.USER_MAIL_REQUIRED, "User first name is required!");

        this.email = email;
    }

    @Override
    public boolean isBroken() {
        return null == email || email.value().isBlank();
    }
}
