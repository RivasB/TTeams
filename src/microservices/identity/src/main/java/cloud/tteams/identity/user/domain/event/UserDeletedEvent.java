package cloud.tteams.identity.user.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.identity.user.domain.User;

public class UserDeletedEvent extends Event<User> {

    public UserDeletedEvent(User data) {
        super(EventType.DELETED, data);
    }
}
