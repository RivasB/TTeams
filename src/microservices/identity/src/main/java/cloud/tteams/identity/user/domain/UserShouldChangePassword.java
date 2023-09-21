package cloud.tteams.identity.user.domain;

import cloud.tteams.share.core.domain.BooleanValueObject;

public class UserShouldChangePassword extends BooleanValueObject {

    public UserShouldChangePassword(Boolean value) {
        super(value);
    }

    public Boolean getValue() {
        return value;
    }

}
