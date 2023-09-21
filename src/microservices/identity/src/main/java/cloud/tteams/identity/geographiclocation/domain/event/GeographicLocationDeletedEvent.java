package cloud.tteams.identity.geographiclocation.domain.event;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class GeographicLocationDeletedEvent extends Event<GeographicLocation> {

    public GeographicLocationDeletedEvent(GeographicLocation data) {
        super(EventType.DELETED, data);
    }

}
