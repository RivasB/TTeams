package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class DeleteAgencyEvent extends Event<Agency> {

    public DeleteAgencyEvent(Agency data) {
        super(EventType.DELETED, data);
    }

}
