package cloud.tteams.identity.profile.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public class ProfileDescription extends StringValueObject {

    public ProfileDescription(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
