package ec.gob.registrocivil.identity.agency.domain;

import ec.gob.registrocivil.share.core.domain.StringValueObject;

public class AgencyRegion extends StringValueObject {

    public AgencyRegion(String value) {
        super(value);
    }

    public String getValue(){
        return value;
    }
}
