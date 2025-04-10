package cloud.tteams.project.project.domain.event;


import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class ProjectUpdatedEvent extends Event {

    public ProjectUpdatedEvent(NotificationMessage data) {
        super(EventType.UPDATED, data);
    }

}
