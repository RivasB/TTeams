package cloud.tteams.identity.agency.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class AgencyNameRequiredRule extends BusinessRule {

    private String name;

    public AgencyNameRequiredRule(String name) {
        super(DomainErrorMessage.AGENCY_NAME_REQUIRED, "Agency name is required!");

        this.name = name;
    }

    @Override
    public boolean isBroken() {
        return null == name || name.isBlank();
    }
}
