package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public final class UserFirstName extends StringValueObject {
    private String value;

    public UserFirstName(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
