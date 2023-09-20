package ec.gob.registrocivil.identity.agency.domain;

import ec.gob.registrocivil.share.core.domain.Identifier;
import java.util.UUID;

public class AgencyId extends Identifier {

    public AgencyId(UUID value) {
        super(value);
    }

    @Override
    public String toString() {
        return "AgencyId [value=" + value.toString() + "]";
    }

    public UUID getValue() {
        return value;
    }

}
