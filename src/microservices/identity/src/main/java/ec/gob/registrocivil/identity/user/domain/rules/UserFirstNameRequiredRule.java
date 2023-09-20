package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserFirstName;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

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
