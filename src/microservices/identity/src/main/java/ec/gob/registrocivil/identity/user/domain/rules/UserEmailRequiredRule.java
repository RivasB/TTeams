package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserEmail;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

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
