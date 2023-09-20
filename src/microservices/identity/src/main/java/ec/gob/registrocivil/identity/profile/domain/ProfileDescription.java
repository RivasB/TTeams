package ec.gob.registrocivil.identity.profile.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class ProfileDescription extends StringValueObject {

    public ProfileDescription(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
