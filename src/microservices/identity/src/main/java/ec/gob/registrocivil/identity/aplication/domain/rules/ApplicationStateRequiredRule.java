package ec.gob.registrocivil.identity.aplication.domain.rules;

import ec.gob.registrocivil.identity.aplication.domain.AplicationState;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

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
