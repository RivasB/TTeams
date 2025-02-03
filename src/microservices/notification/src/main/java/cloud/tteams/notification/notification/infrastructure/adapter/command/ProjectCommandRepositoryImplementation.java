package cloud.tteams.project.project.infrastructure.adapter.command;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectCommandRepository;
import cloud.tteams.project.project.infrastructure.adapter.query.IProjectQueryJPARepository;
import cloud.tteams.project.project.infrastructure.exception.ProjectNotFoundException;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ProjectCommandRepositoryImplementation implements IProjectCommandRepository {

    private final IProjectCommandJPARepository jpaRepository;

    private final IProjectQueryJPARepository readDataJPARepository;

    public ProjectCommandRepositoryImplementation(final IProjectCommandJPARepository jpaRepository, IProjectQueryJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
        this.readDataJPARepository = readDataJPARepository;
    }

    @Override
    public void create(Project project) {
        jpaRepository.save(new ProjectEntity(project));
    }

    @Override
    public void update(Project project) {
        jpaRepository.save(new ProjectEntity(project));
    }

    @Override
    public void delete(ProjectId projectId) {
        ProjectEntity toDelete =
                readDataJPARepository.findById(projectId.getValue()).orElseThrow(ProjectNotFoundException::new);
        jpaRepository.delete(toDelete);
    }
}
