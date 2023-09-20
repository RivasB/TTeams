package ec.gob.registrocivil.identity.aplication.domain.event;

import ec.gob.registrocivil.identity.aplication.domain.Aplication;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class AplicationDeletedEvent extends Event<Aplication> {

    public AplicationDeletedEvent(Aplication data) {
        super(EventType.DELETED, data);
    }

}
