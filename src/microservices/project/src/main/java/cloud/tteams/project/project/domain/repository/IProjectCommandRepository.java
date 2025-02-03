package cloud.tteams.project.project.domain.repository;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.valueobject.ProjectId;

public interface IProjectCommandRepository {

    Project create(Project project);

    Project update(Project project);

    Project delete(ProjectId projectId);
}
