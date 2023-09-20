package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.BooleanValueObject;

public class UserDeleted extends BooleanValueObject {

    public UserDeleted(Boolean value) {
        super(value);
    }

    public Boolean getValue() {
        return value;
    }

}
