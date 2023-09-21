package cloud.tteams.identity.agency.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class AgencyParishRequiredRule extends BusinessRule {

    private String parish;

    public AgencyParishRequiredRule(String parish) {
        super(DomainErrorMessage.AGENCY_PARISH_REQUIRED, "Agency parish is required!");
        this.parish = parish;
    }

    @Override
    public boolean isBroken() {
        return null == parish || parish.isBlank();
    }
}
