package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class UserIdentification extends StringValueObject {
    private String value;

    public UserIdentification(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
