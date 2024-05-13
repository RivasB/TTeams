package cloud.tteams.share.user.domain;


import cloud.tteams.share.core.domain.valueobject.StringValueObject;

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
