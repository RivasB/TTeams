package ec.gob.registrocivil.identity.user.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.user.domain.UserIdentification;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class UserIdentificationRequiredRule extends BusinessRule {

    private UserIdentification identification;

    public UserIdentificationRequiredRule(UserIdentification identification) {
        super(DomainErrorMessage.USER_IDENTIFICATION_REQUIRED, "User identification is required!");

        this.identification = identification;
    }

    @Override
    public boolean isBroken() {
        return null == identification || identification.value().isBlank();
    }
}
