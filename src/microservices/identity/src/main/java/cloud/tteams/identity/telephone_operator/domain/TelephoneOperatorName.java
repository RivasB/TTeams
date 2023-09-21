package cloud.tteams.identity.telephone_operator.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public class TelephoneOperatorName extends StringValueObject {

    public TelephoneOperatorName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
