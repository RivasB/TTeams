package cloud.tteams.identity.aplication.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public final class AplicationName extends StringValueObject {

    public AplicationName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
