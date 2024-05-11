package cloud.tteams.identity.organization.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public final class AgencyDescription extends StringValueObject {

    public AgencyDescription(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
