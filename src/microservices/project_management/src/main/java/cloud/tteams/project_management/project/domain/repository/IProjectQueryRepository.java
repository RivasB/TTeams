package cloud.tteams.project_management.project.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.project_management.project.domain.Project;
import cloud.tteams.project_management.project.domain.ProjectId;
import org.springframework.data.domain.Pageable;

public interface IProjectQueryRepository {

    Project findById(ProjectId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
