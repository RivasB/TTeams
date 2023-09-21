package cloud.tteams.identity.profile.domain;

import java.util.Collection;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.CollectionValueObject;

public class ProfileAccessSet extends CollectionValueObject<Access> {

    public ProfileAccessSet(Collection<Access> value) {
        super(value);
    }

    public Collection<Access> getValue() {
        return value;
    }
}
