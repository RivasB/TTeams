package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class CreateOrganizationEvent extends Event {

    public CreateOrganizationEvent(NotificationMessage data) {
        super(EventType.CREATED, data);
    }
}
