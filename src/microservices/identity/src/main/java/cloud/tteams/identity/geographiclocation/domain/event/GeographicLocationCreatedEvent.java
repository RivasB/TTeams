package cloud.tteams.identity.geographiclocation.domain.event;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class GeographicLocationCreatedEvent extends Event<GeographicLocation> {

    public GeographicLocationCreatedEvent(GeographicLocation data) {
        super(EventType.CREATED, data);
    }

}
