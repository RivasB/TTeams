package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserPassword;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

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
