package ec.gob.registrocivil.identity.profile.domain.rules;

import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

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
