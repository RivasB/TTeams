package cloud.tteams.identity.user.domain;

import cloud.tteams.share.core.domain.valueobject.StringValueObject;

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
