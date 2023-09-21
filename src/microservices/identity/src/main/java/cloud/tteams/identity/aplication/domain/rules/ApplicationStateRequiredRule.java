package cloud.tteams.identity.aplication.domain.rules;

import cloud.tteams.identity.aplication.domain.AplicationState;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ApplicationStateRequiredRule extends BusinessRule {

    AplicationState state;

    public ApplicationStateRequiredRule(AplicationState state) {
        super(DomainErrorMessage.APPLICATION_STATE_REQUIRED, "Application state is required!");
        this.state = state;
    }

    @Override
    public boolean isBroken() {
        return null == state;
    }
}
