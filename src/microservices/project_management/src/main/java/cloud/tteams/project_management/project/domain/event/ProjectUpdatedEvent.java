package cloud.tteams.project_management.project.domain.event;


import cloud.tteams.project_management.project.domain.Project;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class ProjectUpdatedEvent extends Event<Project> {

    public ProjectUpdatedEvent(Project data) {
        super(EventType.UPDATED, data);
    }

}
