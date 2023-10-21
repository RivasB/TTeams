package cloud.tteams.project.project.infrastructure.adapter.query;


import cloud.tteams.project.project.application.ProjectResponse;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.project.project.domain.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectQueryRepository;
import cloud.tteams.project.project.infrastructure.exception.ProjectNotFoundException;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class ProjectQueryRepositoryImplementation implements IProjectQueryRepository {
    private final IProjectQueryJPARepository jpaRepository;

    public ProjectQueryRepositoryImplementation(final IProjectQueryJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Project findById(ProjectId id) {
        ProjectEntity projectEntity = jpaRepository.findById(id.value())
                .orElseThrow(ProjectNotFoundException::new);
        return projectEntity.toAggregate();
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        Page<ProjectEntity> page = jpaRepository.findAll(pageable);
        return this.result(page);
    }


    private MessagePaginatedResponse result(Page<ProjectEntity> page) {
        List<ProjectResponse> response = page.stream()
                .map(item -> new ProjectResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
