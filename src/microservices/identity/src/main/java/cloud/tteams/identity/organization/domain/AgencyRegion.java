package cloud.tteams.identity.organization.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public class AgencyRegion extends StringValueObject {

    public AgencyRegion(String value) {
        super(value);
    }

    public String getValue(){
        return value;
    }
}
