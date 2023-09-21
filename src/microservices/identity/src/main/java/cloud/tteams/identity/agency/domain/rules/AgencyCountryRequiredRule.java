package cloud.tteams.identity.agency.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

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
