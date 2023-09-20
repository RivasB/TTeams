package ec.gob.registrocivil.identity.aplication.domain.event;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class AplicationUpdatedEvent extends Event<Aplication> {

    public AplicationUpdatedEvent(Aplication data) {
        super(EventType.UPDATED, data);
    }

}
