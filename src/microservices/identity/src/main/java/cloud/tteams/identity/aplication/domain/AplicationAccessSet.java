package cloud.tteams.identity.aplication.domain;

import java.util.Collection;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.CollectionValueObject;

public class AplicationAccessSet extends CollectionValueObject<Access> {

    public AplicationAccessSet(Collection<Access> value) {
        super(value);
    }

    public Collection<Access> getValue() {
        return value;
    }

}
