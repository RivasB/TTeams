package ec.gob.registrocivil.identity.telephone_operator.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class TelephoneOperatorName extends StringValueObject {

    public TelephoneOperatorName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
