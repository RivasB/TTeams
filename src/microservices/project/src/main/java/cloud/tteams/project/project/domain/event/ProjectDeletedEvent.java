package cloud.tteams.project.project.domain.event;


import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.event.message.notification.NotificationMessage;

public class ProjectDeletedEvent extends Event {

    public ProjectDeletedEvent(NotificationMessage data) {
        super(EventType.DELETED, data);
    }

}
