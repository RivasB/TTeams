package cloud.tteams.project_management.project.domain.event;


import cloud.tteams.project_management.project.domain.Project;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class ProjectCreatedEvent extends Event<Project> {

    public ProjectCreatedEvent(Project data) {
        super(EventType.CREATED, data);
    }

}
