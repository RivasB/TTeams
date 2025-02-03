package cloud.tteams.project.project.infrastructure.adapter.command;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectCommandRepository;
import cloud.tteams.project.project.infrastructure.adapter.query.IProjectQueryJPARepository;
import cloud.tteams.project.project.infrastructure.exception.ProjectNotFoundException;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Primary
public class ProjectCommandRepositoryImplementation implements IProjectCommandRepository {

    private final IProjectCommandJPARepository jpaRepository;

    private final IProjectQueryJPARepository readDataJPARepository;

    private final Log logger = LogFactory.getLog(this.getClass());

    public ProjectCommandRepositoryImplementation(final IProjectCommandJPARepository jpaRepository, IProjectQueryJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
        this.readDataJPARepository = readDataJPARepository;
    }

    @Override
    public Project create(Project project) {
        return jpaRepository
                .save(new ProjectEntity(project))
                .toAggregate();
    }

    @Override
    public Project update(Project project) {
        ProjectEntity entityToUpdate =
                readDataJPARepository.findById(project.getId().getValue()).orElseThrow(ProjectNotFoundException::new);
        Project toUpdateProject = entityToUpdate.toAggregate();
        Field[] fields = project.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object value = attrib.get(project);
                Object valueToUpdate = attrib.get(toUpdateProject);
                if (value != null && !value.equals(valueToUpdate)
                        && attrib.getType().isAssignableFrom(value.getClass())) {
                    attrib.set(toUpdateProject, value);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        jpaRepository.save(new ProjectEntity(toUpdateProject));
        return toUpdateProject;
    }

    @Override
    public Project delete(ProjectId projectId) {
        ProjectEntity toDelete =
                readDataJPARepository.findById(projectId.getValue()).orElseThrow(ProjectNotFoundException::new);
        toDelete.setAsDeleted();
        return jpaRepository.save(toDelete).toAggregate();
    }
}
