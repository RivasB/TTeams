package ec.gob.registrocivil.identity.profile.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

public class ProfileAgencyRequiredRule extends BusinessRule {

    private UUID agency;

    public ProfileAgencyRequiredRule(UUID agency) {
        super(DomainErrorMessage.PROFILE_AGENCY_REQUIRED, "Profile agency is required!");
        this.agency = agency;
    }

    @Override
    public boolean isBroken() {
        return null == agency || agency.toString().isBlank();
    }
}
