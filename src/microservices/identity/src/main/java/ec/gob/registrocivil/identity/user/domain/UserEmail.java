package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class UserEmail extends StringValueObject {
    private String value;

    public UserEmail(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
