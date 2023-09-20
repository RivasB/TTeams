package ec.gob.registrocivil.identity.security.domain.rules;

import java.util.Optional;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class UserMustBeRegistred extends BusinessRule {

    Optional<User> appUser;

    public UserMustBeRegistred(Optional<User> appUser) {
        super(DomainErrorMessage.USER_MUST_BE_REGISTERED, "User must be registred");
        this.appUser = appUser;
    }

    @Override
    public boolean isBroken() {
        return !appUser.isPresent();
    }

}
