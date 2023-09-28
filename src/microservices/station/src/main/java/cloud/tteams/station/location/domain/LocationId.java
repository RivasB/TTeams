package cloud.tteams.station.location.domain;

import cloud.tteams.share.core.domain.Identifier;

import java.util.UUID;

public class LocationId extends Identifier {
    public LocationId(UUID value) {
        super(value);
    }
}
