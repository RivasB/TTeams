package cloud.tteams.identity.security.domain.rules;

import java.util.Optional;

import cloud.tteams.identity.user.domain.User;
import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

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
