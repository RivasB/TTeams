package cloud.tteams.share.user.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.user.domain.User;

public class UserUpdatedEvent extends Event<User> {

    public UserUpdatedEvent(User data) {
        super(EventType.UPDATED, data);
    }
}
