package cloud.tteams.identity.user.domain;

import java.util.Collection;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.valueobject.CollectionValueObject;

public class UserProfileSet extends CollectionValueObject<Profile> {

    public UserProfileSet(Collection<Profile> value) {
        super(value);
    }

    public Collection<Profile> getValue() {
        return value;
    }
}
