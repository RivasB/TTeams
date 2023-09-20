package ec.gob.registrocivil.identity.user.domain;

import ec.gob.registrocivil.share.core.domain.BooleanValueObject;

public class UserShouldChangePassword extends BooleanValueObject {

    public UserShouldChangePassword(Boolean value) {
        super(value);
    }

    public Boolean getValue() {
        return value;
    }

}
