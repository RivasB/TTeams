package ec.gob.registrocivil.identity.aplication.domain.rules;

import ec.gob.registrocivil.identity.aplication.domain.AplicationAccessSet;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class ApplicationAccessRequiredRule extends BusinessRule {

    AplicationAccessSet access;

    public ApplicationAccessRequiredRule(AplicationAccessSet access) {
        super(DomainErrorMessage.APPLICATION_ACCESS_REQUIRED, "Application must have at least one asociated access!");
        this.access = access;
    }

    @Override
    public boolean isBroken() {
        return null == access || null == access.getValue() || access.getValue().isEmpty();
    }
}
