package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class UpdateOrganizationEvent extends Event {

    public UpdateOrganizationEvent(NotificationMessage data) {
        super(EventType.UPDATED, data);
    }

}
