package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class UpdateAgencyEvent extends Event<Agency> {

    public UpdateAgencyEvent(Agency data) {
        super(EventType.UPDATED, data);
    }

}
