package cloud.tteams.identity.agency.domain.event;

import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class UpdateAgencyEvent extends Event<Agency> {

    public UpdateAgencyEvent(Agency data) {
        super(EventType.UPDATED, data);
    }

}
