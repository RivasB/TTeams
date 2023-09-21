package cloud.tteams.identity.profile.domain.rules;

import cloud.tteams.identity.profile.domain.ProfileState;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileStateRequiredRule extends BusinessRule {

    private ProfileState state;

    public ProfileStateRequiredRule(ProfileState state) {
        super(DomainErrorMessage.PROFILE_STATE_REQUIRED, "Profile state is required!");
        this.state = state;
    }

    @Override
    public boolean isBroken() {
        return null == state;
    }
}
