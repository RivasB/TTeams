package ec.gob.registrocivil.identity.profile.domain.rules;

import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;
import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;

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
