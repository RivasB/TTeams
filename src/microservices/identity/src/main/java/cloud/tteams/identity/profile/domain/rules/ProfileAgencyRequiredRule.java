package cloud.tteams.identity.profile.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import java.util.UUID;

import cloud.tteams.share.core.domain.rules.BusinessRule;

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
