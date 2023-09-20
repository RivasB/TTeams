package ec.gob.registrocivil.identity.aplication.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public final class AplicationDescription extends StringValueObject {

    public AplicationDescription(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
