package ec.gob.registrocivil.identity.aplication.domain.event;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class AplicationCreatedEvent extends Event<Aplication> {

    public AplicationCreatedEvent(Aplication data) {
        super(EventType.CREATED, data);
    }

}
