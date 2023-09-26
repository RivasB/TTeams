package cloud.tteams.identity.access.domain.rules;

import cloud.tteams.identity.access.domain.AccessDescription;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class AccessDescriptionMustBeRequiredRule extends BusinessRule {

    private AccessDescription description;

    public AccessDescriptionMustBeRequiredRule(AccessDescription description) {
        super(DomainErrorMessage.ACCESS_DESCRIPTION_REQUIRED, "Access description must be unique!");
        this.description = description;
    }

    @Override
    public boolean isBroken() {
        return null == description || description.value().isBlank();
    }
}
