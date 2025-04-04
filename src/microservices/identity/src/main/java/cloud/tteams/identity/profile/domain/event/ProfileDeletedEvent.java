package cloud.tteams.identity.profile.domain.event;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.notification.Notification;

public class ProfileDeletedEvent extends Event{

    public ProfileDeletedEvent(Notification data) {
        super(EventType.DELETED, data);
    }

}
