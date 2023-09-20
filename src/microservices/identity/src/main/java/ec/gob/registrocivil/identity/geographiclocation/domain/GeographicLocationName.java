package ec.gob.registrocivil.identity.geographiclocation.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class GeographicLocationName extends StringValueObject {

    public GeographicLocationName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
