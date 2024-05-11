package cloud.tteams.identity.application.domain.rules;

import cloud.tteams.share.core.domain.exception.DomainErrorMessage;
import cloud.tteams.share.core.domain.rules.BusinessRule;

public class ApplicationNameRequiredRule extends BusinessRule {

    private String name;

    public ApplicationNameRequiredRule(String name) {
        super(DomainErrorMessage.APPLICATION_NAME_REQUIRED, "Application name is required!");
        this.name = name;
    }

    @Override
    public boolean isBroken() {
        return null == name || name.isBlank();
    }
}
