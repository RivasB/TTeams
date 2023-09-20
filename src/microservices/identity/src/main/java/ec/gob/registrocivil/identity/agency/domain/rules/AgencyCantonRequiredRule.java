package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AgencyCantonRequiredRule extends BusinessRule {

    private String canton;

    public AgencyCantonRequiredRule(String canton) {
        super(DomainErrorMessage.AGENCY_CANTON_REQUIRED, "Agency canton is required!");
        this.canton = canton;
    }

    @Override
    public boolean isBroken() {
        return null == canton || canton.isBlank();
    }
}
