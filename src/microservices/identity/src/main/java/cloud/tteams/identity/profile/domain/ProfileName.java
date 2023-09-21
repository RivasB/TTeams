package cloud.tteams.identity.profile.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public class ProfileName extends StringValueObject {

    public ProfileName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
