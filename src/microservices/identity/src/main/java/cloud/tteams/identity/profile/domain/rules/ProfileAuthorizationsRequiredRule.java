package cloud.tteams.identity.profile.domain.rules;

import java.util.Collection;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ProfileAuthorizationsRequiredRule extends BusinessRule {

    private final Collection<Authorization> authorizations;

    public ProfileAuthorizationsRequiredRule(Collection<Authorization> authorizations) {
        super("Profile must have at least one associated authorization!");
        this.authorizations = authorizations;
    }

    @Override
    public boolean isBroken() {
        return authorizations.isEmpty();
    }
}
