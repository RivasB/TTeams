package cloud.tteams.identity.user.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class UserCreatedEvent extends Event {

    public UserCreatedEvent(NotificationMessage data) {
        super(EventType.CREATED, data);
    }
}
