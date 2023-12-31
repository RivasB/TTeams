package cloud.tteams.identity.aplication.domain.rules;

import cloud.tteams.identity.aplication.domain.AplicationAccessSet;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

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
