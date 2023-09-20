package ec.gob.registrocivil.identity.agency.domain.event;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class UpdateAgencyEvent extends Event<Agency> {

    public UpdateAgencyEvent(Agency data) {
        super(EventType.UPDATED, data);
    }

}
