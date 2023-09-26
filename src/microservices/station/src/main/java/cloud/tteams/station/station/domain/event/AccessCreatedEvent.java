package cloud.tteams.identity.access.domain.event;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AccessCreatedEvent extends Event<Access> {

    public AccessCreatedEvent(Access data) {
        super(EventType.CREATED, data);
    }

}
