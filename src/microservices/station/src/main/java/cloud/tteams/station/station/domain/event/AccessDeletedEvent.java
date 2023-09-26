package cloud.tteams.identity.access.domain.event;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AccessDeletedEvent extends Event<Access> {

    public AccessDeletedEvent(Access data) {
        super(EventType.DELETED, data);
    }

}
