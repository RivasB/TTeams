package ec.gob.registrocivil.identity.geographiclocation.domain;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.Identifier;

public class GeographicLocationId extends Identifier {

    public GeographicLocationId(UUID value) {
        super(value);
    }

    public UUID getValue() {
        return value;
    }

}
