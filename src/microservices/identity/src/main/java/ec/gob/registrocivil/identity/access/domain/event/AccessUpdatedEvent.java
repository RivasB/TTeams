package ec.gob.registrocivil.identity.access.domain.event;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class AccessUpdatedEvent extends Event<Access> {

    public AccessUpdatedEvent(Access data) {
        super(EventType.UPDATED, data);
    }

}
