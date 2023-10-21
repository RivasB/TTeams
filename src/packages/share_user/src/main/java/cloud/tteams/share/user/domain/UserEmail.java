package cloud.tteams.share.user.domain;


import cloud.tteams.share.core.domain.StringValueObject;

public class UserEmail extends StringValueObject {
    private String value;

    public UserEmail(String value) {
        super(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
