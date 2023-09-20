package ec.gob.registrocivil.identity.agency.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public final class AgencyLatitude extends StringValueObject {

    public AgencyLatitude(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
