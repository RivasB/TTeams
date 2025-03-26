package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.notification.Notification;

public class UpdateOrganizationEvent extends Event {

    public UpdateOrganizationEvent(Notification data) {
        super(EventType.UPDATED, data);
    }

}
