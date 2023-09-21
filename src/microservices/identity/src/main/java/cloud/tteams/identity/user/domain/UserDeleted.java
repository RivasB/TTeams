package cloud.tteams.identity.user.domain;

import cloud.tteams.share.core.domain.BooleanValueObject;

public class UserDeleted extends BooleanValueObject {

    public UserDeleted(Boolean value) {
        super(value);
    }

    public Boolean getValue() {
        return value;
    }

}
