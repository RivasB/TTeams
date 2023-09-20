package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.identity.agency.domain.AgencyState;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

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
