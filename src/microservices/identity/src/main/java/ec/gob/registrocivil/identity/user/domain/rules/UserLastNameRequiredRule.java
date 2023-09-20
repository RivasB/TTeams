package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserLastName;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

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
