package ec.gob.registrocivil.identity.geographiclocation.domain.event;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class GeographicLocationDeletedEvent extends Event<GeographicLocation> {

    public GeographicLocationDeletedEvent(GeographicLocation data) {
        super(EventType.DELETED, data);
    }

}
