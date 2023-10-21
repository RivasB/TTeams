package cloud.tteams.project.project.domain.repository;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.ProjectId;
import org.springframework.data.domain.Pageable;

public interface IProjectQueryRepository {

    Project findById(ProjectId id);

    MessagePaginatedResponse findAll(Pageable pageable);

    }
