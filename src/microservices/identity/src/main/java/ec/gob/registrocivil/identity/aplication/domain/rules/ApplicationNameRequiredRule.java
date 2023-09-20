package ec.gob.registrocivil.identity.aplication.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

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
