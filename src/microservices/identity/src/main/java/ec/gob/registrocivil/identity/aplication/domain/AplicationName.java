package ec.gob.registrocivil.identity.aplication.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public final class AplicationName extends StringValueObject {

    public AplicationName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
