package cloud.tteams.identity.profile.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class ProfileId extends Identifier {

    public ProfileId(UUID value) {
        super(value);
    }

    @Override
    public String toString() {
        return "ProfileId [value=" + value.toString() + "]";
    }

    public UUID getValue() {
        return value;
    }

}
