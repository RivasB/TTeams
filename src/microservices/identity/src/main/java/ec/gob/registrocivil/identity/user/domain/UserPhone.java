package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class UserPhone extends StringValueObject {

    public UserPhone(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
