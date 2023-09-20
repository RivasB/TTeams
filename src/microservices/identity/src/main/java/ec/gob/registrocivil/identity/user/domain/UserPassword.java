package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class UserPassword extends StringValueObject {
    private String value;

    public UserPassword(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
