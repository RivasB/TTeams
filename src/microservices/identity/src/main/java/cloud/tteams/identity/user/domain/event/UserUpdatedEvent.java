package cloud.tteams.identity.user.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.identity.user.domain.User;
import cloud.tteams.share.core.domain.notification.Notification;

public class UserUpdatedEvent extends Event {

    public UserUpdatedEvent(Notification data) {
        super(EventType.UPDATED, data);
    }
}
