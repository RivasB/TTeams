package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.notification.Notification;

public class DeleteOrganizationEvent extends Event {

    public DeleteOrganizationEvent(Notification data) {
        super(EventType.DELETED, data);
    }

}
