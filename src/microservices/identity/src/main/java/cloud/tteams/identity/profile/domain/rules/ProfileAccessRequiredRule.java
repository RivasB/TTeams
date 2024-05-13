package cloud.tteams.identity.profile.domain.rules;

import java.util.Collection;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileAccessRequiredRule extends BusinessRule {

    private Collection<Authorization> authorizations;

    public ProfileAccessRequiredRule(Collection<Authorization> authorizations) {
        super(DomainErrorMessage.PROFILE_ACCESS_REQUIRED, "Profile must have at least one associated authorization!");
        this.authorizations = authorizations;
    }

    @Override
    public boolean isBroken() {
        return null == authorizations || authorizations.isEmpty();
    }
}
