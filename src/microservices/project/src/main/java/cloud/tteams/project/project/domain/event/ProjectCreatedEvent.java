package cloud.tteams.project.project.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.notification.Notification;

public class ProjectCreatedEvent extends Event {

    public ProjectCreatedEvent(Notification data) {
        super(EventType.CREATED, data);
    }

}
