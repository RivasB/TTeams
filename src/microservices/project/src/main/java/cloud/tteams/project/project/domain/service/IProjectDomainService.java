package cloud.tteams.project.project.domain.service;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import org.springframework.data.domain.Pageable;

public interface IProjectDomainService{

    void create(Project project);

    void update(Project project);

    void delete(ProjectId projectId);

    Project findById(ProjectId projectId);

    MessagePaginatedResponse findAll(Pageable pageable);
}
