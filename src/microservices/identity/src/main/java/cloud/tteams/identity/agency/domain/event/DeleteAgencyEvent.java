package cloud.tteams.identity.agency.domain.event;

import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class DeleteAgencyEvent extends Event<Agency> {

    public DeleteAgencyEvent(Agency data) {
        super(EventType.DELETED, data);
    }

}
