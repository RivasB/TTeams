package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class UserLastName extends StringValueObject {
    private String value;

    public UserLastName(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
