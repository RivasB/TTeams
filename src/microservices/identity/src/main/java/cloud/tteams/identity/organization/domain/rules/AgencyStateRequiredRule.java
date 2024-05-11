package cloud.tteams.identity.organization.domain.rules;

import cloud.tteams.identity.organization.domain.AgencyState;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class AgencyStateRequiredRule extends BusinessRule {

    private AgencyState state;

    public AgencyStateRequiredRule(AgencyState state) {
        super(DomainErrorMessage.AGENCY_STATE_REQUIRED, "Agency state is required!");
        this.state = state;
    }

    @Override
    public boolean isBroken() {
        return null == state;
    }
}
