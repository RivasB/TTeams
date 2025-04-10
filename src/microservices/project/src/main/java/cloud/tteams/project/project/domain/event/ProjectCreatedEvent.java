package cloud.tteams.project.project.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class ProjectCreatedEvent extends Event {

    public ProjectCreatedEvent(NotificationMessage data) {
        super(EventType.CREATED, data);
    }

}
