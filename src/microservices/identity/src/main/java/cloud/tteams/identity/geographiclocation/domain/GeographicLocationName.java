package cloud.tteams.identity.geographiclocation.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public class GeographicLocationName extends StringValueObject {

    public GeographicLocationName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }
}
