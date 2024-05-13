package cloud.tteams.identity.user.domain;

import cloud.tteams.share.core.domain.valueobject.StringValueObject;

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
