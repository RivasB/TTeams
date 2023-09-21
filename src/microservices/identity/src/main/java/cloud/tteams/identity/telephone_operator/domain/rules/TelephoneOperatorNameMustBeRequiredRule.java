package cloud.tteams.identity.telephone_operator.domain.rules;

import cloud.tteams.share.core.domain.rules.BusinessRule;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorName;
import cloud.tteams.share.core.domain.exception.DomainErrorMessage;

public class TelephoneOperatorNameMustBeRequiredRule extends BusinessRule {

    private TelephoneOperatorName name;

    public TelephoneOperatorNameMustBeRequiredRule(TelephoneOperatorName name) {
        super(DomainErrorMessage.TELEPHONE_OPERATOR_NAME_REQUIRED, "Telephone Operator is required!");
        this.name = name;
    }

    @Override
    public boolean isBroken() {
        return name == null || name.value().isBlank();
    }

}
