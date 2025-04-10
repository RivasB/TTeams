package cloud.tteams.identity.user.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class UserDeletedEvent extends Event {

    public UserDeletedEvent(NotificationMessage data) {
        super(EventType.DELETED, data);
    }
}
