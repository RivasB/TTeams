package ec.gob.registrocivil.identity.agency.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class AgencyCityRequiredRule extends BusinessRule {

    private String city;

    public AgencyCityRequiredRule(String city) {
        super(DomainErrorMessage.AGENCY_CITY_REQUIRED, "Agency city is required!");
        this.city = city;
    }

    @Override
    public boolean isBroken() {
        return null == city || city.isBlank();
    }
}
