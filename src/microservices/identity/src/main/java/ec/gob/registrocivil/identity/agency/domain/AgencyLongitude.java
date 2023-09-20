package ec.gob.registrocivil.identity.agency.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public final class AgencyLongitude extends StringValueObject {

    public AgencyLongitude(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
