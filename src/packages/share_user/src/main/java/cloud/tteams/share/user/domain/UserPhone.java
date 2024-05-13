package cloud.tteams.share.user.domain;


import cloud.tteams.share.core.domain.valueobject.StringValueObject;

public class UserPhone extends StringValueObject {

    public UserPhone(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
