package cloud.tteams.project.project.domain.event;


import cloud.tteams.project.project.domain.Project;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.notification.Notification;

public class ProjectUpdatedEvent extends Event<Notification> {

    public ProjectUpdatedEvent(Notification data) {
        super(EventType.UPDATED, data);
    }

}
