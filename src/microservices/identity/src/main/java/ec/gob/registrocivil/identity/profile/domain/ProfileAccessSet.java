package ec.gob.registrocivil.identity.profile.domain;

import java.util.Collection;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.share.core.domain.CollectionValueObject;

public class ProfileAccessSet extends CollectionValueObject<Access> {

    public ProfileAccessSet(Collection<Access> value) {
        super(value);
    }

    public Collection<Access> getValue() {
        return value;
    }
}
