package cloud.tteams.identity.access.domain.event;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AccessUpdatedEvent extends Event<Access> {

    public AccessUpdatedEvent(Access data) {
        super(EventType.UPDATED, data);
    }

}
