package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class CreateAgencyEvent extends Event<Agency> {

    public CreateAgencyEvent(Agency data) {
        super(EventType.CREATED, data);
    }
}
