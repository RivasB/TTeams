package ec.gob.registrocivil.identity.aplication.domain;

import java.util.Collection;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.share.core.domain.CollectionValueObject;

public class AplicationAccessSet extends CollectionValueObject<Access> {

    public AplicationAccessSet(Collection<Access> value) {
        super(value);
    }

    public Collection<Access> getValue() {
        return value;
    }

}
