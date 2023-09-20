package ec.gob.registrocivil.identity.telephone_operator.domain.rules;

import ec.gob.registrocivil.share.core.domain.rules.BusinessRule;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.service.ITelephoneOperatorService;
import ec.gob.registrocivil.share.core.domain.exception.DomainErrorMessage;

public class TelephoneOperatorNameMustBeUniqueRule extends BusinessRule {

    private ITelephoneOperatorService service;

    private TelephoneOperator operator;

    public TelephoneOperatorNameMustBeUniqueRule(ITelephoneOperatorService service, TelephoneOperator operator) {
        super(DomainErrorMessage.TELEPHONE_OPERATOR_NAME_UNIQUE, "Telephone operator name must be unique!");
        this.service = service;
        this.operator = operator;
    }

    @Override
    public boolean isBroken() {
        return operator.getName() == null || operator.getName().value() == null ||
                service.countByIdIsNotAndName(operator.getId(), operator.getName()) > 0;
    }

}
