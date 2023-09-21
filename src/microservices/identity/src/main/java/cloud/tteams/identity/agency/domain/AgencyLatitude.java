package cloud.tteams.identity.agency.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public final class AgencyLatitude extends StringValueObject {

    public AgencyLatitude(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
