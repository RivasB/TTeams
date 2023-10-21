package cloud.tteams.share.user.domain.event;


import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.user.domain.User;

public class UserCreatedEvent extends Event<User> {

    public UserCreatedEvent(User data) {
        super(EventType.CREATED, data);
    }
}
