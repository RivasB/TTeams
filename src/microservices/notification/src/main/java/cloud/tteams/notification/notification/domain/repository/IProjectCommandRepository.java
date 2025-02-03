package cloud.tteams.project.project.domain.repository;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.ProjectId;

public interface IProjectCommandRepository {

    void create(Project project);

    void update(Project project);

    void delete(ProjectId projectId);
}
