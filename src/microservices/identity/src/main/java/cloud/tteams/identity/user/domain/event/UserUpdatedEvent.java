package cloud.tteams.identity.user.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class UserUpdatedEvent extends Event {

    public UserUpdatedEvent(NotificationMessage data) {
        super(EventType.UPDATED, data);
    }
}
