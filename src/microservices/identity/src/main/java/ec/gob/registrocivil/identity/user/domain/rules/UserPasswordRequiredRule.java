package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserPassword;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class UserPasswordRequiredRule extends BusinessRule {

    private UserPassword password;

    public UserPasswordRequiredRule(UserPassword password) {
        super(DomainErrorMessage.USER_PASSWORD_REQUIRED, "User password is required!");
        this.password = password;
    }

    @Override
    public boolean isBroken() {
        return null == password || password.getValue().isBlank();
    }

}
