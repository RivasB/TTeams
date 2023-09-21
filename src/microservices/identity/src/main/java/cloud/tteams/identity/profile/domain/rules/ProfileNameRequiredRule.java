package cloud.tteams.identity.profile.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileNameRequiredRule extends BusinessRule {

    private String name;

    public ProfileNameRequiredRule(String name) {
        super(DomainErrorMessage.PROFILE_NAME_REQUIRED, "Profile name is required!");
        this.name = name;
    }

    @Override
    public boolean isBroken() {
        return null == name || name.isBlank();
    }
}
