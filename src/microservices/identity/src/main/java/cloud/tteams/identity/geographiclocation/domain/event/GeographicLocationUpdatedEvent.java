package cloud.tteams.identity.geographiclocation.domain.event;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class GeographicLocationUpdatedEvent extends Event<GeographicLocation> {

    public GeographicLocationUpdatedEvent(GeographicLocation data) {
        super(EventType.UPDATED, data);
    }

}
