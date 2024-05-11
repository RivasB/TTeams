package cloud.tteams.identity.authorization.domain.event;

import cloud.tteams.identity.authorization.domain.Access;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AccessCreatedEvent extends Event<Access> {

    public AccessCreatedEvent(Access data) {
        super(EventType.CREATED, data);
    }

}
