package cloud.tteams.identity.agency.domain.event;

import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class CreateAgencyEvent extends Event<Agency> {

    public CreateAgencyEvent(Agency data) {
        super(EventType.CREATED, data);
    }
}
