package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class DeleteOrganizationEvent extends Event {

    public DeleteOrganizationEvent(NotificationMessage data) {
        super(EventType.DELETED, data);
    }

}
