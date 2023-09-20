package ec.gob.registrocivil.identity.agency.domain.event;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class CreateAgencyEvent extends Event<Agency> {

    public CreateAgencyEvent(Agency data) {
        super(EventType.CREATED, data);
    }
}
