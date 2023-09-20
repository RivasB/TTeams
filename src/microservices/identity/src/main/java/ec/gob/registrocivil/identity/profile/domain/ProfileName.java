package ec.gob.registrocivil.identity.profile.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class ProfileName extends StringValueObject {

    public ProfileName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
