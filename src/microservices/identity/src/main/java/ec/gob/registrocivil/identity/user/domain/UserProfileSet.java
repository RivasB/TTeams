package ec.gob.registrocivil.identity.user.domain;

import java.util.Collection;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.share.core.domain.CollectionValueObject;

public class UserProfileSet extends CollectionValueObject<Profile> {

    public UserProfileSet(Collection<Profile> value) {
        super(value);
    }

    public Collection<Profile> getValue() {
        return value;
    }
}
