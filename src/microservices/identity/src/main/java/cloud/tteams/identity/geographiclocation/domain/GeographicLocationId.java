package cloud.tteams.identity.geographiclocation.domain;

import java.util.UUID;

import cloud.tteams.share.core.domain.Identifier;

public class GeographicLocationId extends Identifier {

    public GeographicLocationId(UUID value) {
        super(value);
    }

    public UUID getValue() {
        return value;
    }

}
