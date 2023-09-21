package cloud.tteams.identity.aplication.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public final class AplicationDescription extends StringValueObject {

    public AplicationDescription(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
