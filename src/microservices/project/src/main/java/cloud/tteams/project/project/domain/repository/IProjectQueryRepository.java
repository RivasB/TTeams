package cloud.tteams.project.project.domain.repository;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import org.springframework.data.domain.Pageable;

public interface IProjectQueryRepository {

    Project findById(ProjectId id);

    MessagePaginatedResponse findAll(Pageable pageable, Object filters);

    }
