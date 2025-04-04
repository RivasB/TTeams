package cloud.tteams.project.project.infrastructure.adapter.query;


import cloud.tteams.project.project.application.query.ProjectResponse;
import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.infrastructure.repository.jpa.ProjectSpecification;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectQueryRepository;
import cloud.tteams.project.project.infrastructure.exception.ProjectNotFoundException;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
    @SuppressWarnings("unchecked")
    public MessagePaginatedResponse findAll(Pageable pageable, Object filters) {
        Page<ProjectEntity> page;
        if (filters instanceof Map<?, ?>) {
            Map<String, Object> filterMap = (Map<String, Object>) filters;
            Specification<ProjectEntity> specification = ProjectSpecification.buildSpecification(filterMap);
            page = jpaRepository.findAll(specification, pageable);
        }
        else {
            page = jpaRepository.findAll(pageable);
        }
        return this.result(page);
    }


    private MessagePaginatedResponse result(Page<ProjectEntity> page) {
        List<ProjectResponse> response = page.stream()
                .map(item -> new ProjectResponse(item.toAggregate())).toList();
        return new MessagePaginatedResponse(response, page);
    }

}
