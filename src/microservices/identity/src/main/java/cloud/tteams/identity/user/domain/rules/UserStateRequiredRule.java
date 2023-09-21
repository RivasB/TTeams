package cloud.tteams.identity.user.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.user.domain.UserState;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

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
