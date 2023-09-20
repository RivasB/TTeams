package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AgencyCountryRequiredRule extends BusinessRule {

    private String country;

    public AgencyCountryRequiredRule(String country) {
        super(DomainErrorMessage.AGENCY_COUNTRY_REQUIRED, "Agency country is required!");

        this.country = country;
    }

    @Override
    public boolean isBroken() {
        return null == country || country.isBlank();
    }
}
