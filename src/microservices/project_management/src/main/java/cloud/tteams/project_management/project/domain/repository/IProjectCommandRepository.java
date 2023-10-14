package cloud.tteams.project_management.project.domain.repository;

import cloud.tteams.project_management.project.domain.Project;
import cloud.tteams.project_management.project.domain.ProjectId;

public interface IProjectCommandRepository {

    void create(Project project);

    void update(Project project);

    void delete(ProjectId projectId);
}
