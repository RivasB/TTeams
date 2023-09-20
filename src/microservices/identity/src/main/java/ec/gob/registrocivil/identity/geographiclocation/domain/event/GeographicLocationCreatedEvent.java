package ec.gob.registrocivil.identity.geographiclocation.domain.event;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class GeographicLocationCreatedEvent extends Event<GeographicLocation> {

    public GeographicLocationCreatedEvent(GeographicLocation data) {
        super(EventType.CREATED, data);
    }

}
