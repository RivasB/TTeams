package cloud.tteams.identity.agency.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public final class AgencyLongitude extends StringValueObject {

    public AgencyLongitude(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
