package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AgencyRegionMustBeRequiredRule extends BusinessRule {

    private String region;

    public AgencyRegionMustBeRequiredRule(String region) {
        super(DomainErrorMessage.AGENCY_REGION_REQUIRED, "Agency region is required!");
        this.region = region;
    }

    @Override
    public boolean isBroken() {
        return null == region;
    }
}
