package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserState;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class UserStateRequiredRule extends BusinessRule {

    private UserState state;

    public UserStateRequiredRule(UserState state) {
        super(DomainErrorMessage.USER_STATE_REQUIRED, "User state is required!");

        this.state = state;
    }

    @Override
    public boolean isBroken() {
        return null == state;
    }
}
