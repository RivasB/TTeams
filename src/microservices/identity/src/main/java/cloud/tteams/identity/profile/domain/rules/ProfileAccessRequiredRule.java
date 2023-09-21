package cloud.tteams.identity.profile.domain.rules;

import java.util.Collection;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileAccessRequiredRule extends BusinessRule {

    private Collection<Access> access;

    public ProfileAccessRequiredRule(Collection<Access> access) {
        super(DomainErrorMessage.PROFILE_ACCESS_REQUIRED, "Profile must have at least one associated access!");
        this.access = access;
    }

    @Override
    public boolean isBroken() {
        return null == access || access.isEmpty();
    }
}
