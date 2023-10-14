package cloud.tteams.project_management.project.domain.service;


import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.project_management.project.domain.Project;
import cloud.tteams.project_management.project.domain.ProjectId;
import org.springframework.data.domain.Pageable;

public interface IProjectDomainService {
    void create(Project project);

    void update(Project project);

    void delete(ProjectId projectId);

    Project findById(ProjectId id);

    MessagePaginatedResponse findAll(Pageable pageable);

}
