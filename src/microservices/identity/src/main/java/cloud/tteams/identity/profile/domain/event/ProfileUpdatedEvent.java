package cloud.tteams.identity.profile.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class ProfileUpdatedEvent extends Event {

    public ProfileUpdatedEvent(NotificationMessage data) {
        super(EventType.UPDATED, data);
    }

}