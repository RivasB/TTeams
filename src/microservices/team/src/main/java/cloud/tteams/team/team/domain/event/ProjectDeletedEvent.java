package cloud.tteams.project.project.domain.event;


import cloud.tteams.project.project.domain.Project;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class ProjectDeletedEvent extends Event<Project> {

    public ProjectDeletedEvent(Project data) {
        super(EventType.DELETED, data);
    }

}
