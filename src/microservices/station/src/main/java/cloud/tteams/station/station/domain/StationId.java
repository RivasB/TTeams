package cloud.tteams.station.station.domain;

import cloud.tteams.share.core.domain.Identifier;

import java.util.UUID;

public class StationId extends Identifier {
    public StationId(UUID value) {
        super(value);
    }
}
