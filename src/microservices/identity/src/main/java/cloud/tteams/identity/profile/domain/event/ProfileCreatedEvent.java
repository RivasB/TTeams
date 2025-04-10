package cloud.tteams.identity.profile.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class ProfileCreatedEvent extends Event {

    public ProfileCreatedEvent(NotificationMessage data) {
        super(EventType.CREATED, data);
    }
}
