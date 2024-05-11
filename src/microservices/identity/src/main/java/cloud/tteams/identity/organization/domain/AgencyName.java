package cloud.tteams.identity.organization.domain;

import cloud.tteams.share.core.domain.StringValueObject;

public final class AgencyName extends StringValueObject {

    public AgencyName(String value) {
        super(value);
    }

    public String getValue() {
        return value;
    }

}
