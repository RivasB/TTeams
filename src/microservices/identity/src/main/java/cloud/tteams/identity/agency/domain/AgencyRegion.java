package cloud.tteams.identity.agency.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public class AgencyRegion extends StringValueObject {

    public AgencyRegion(String value) {
        super(value);
    }

    public String getValue(){
        return value;
    }
}
