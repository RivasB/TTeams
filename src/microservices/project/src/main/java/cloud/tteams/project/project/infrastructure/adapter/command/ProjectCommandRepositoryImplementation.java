package cloud.tteams.project.project.infrastructure.adapter.command;

import cloud.tteams.project.project.domain.Project;
import cloud.tteams.project.project.domain.rules.ProjectNameMustBeUnique;
import cloud.tteams.project.project.domain.rules.ProjectStartDateMustBeBeforeEstimatedEndDate;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectCommandRepository;
import cloud.tteams.project.project.infrastructure.adapter.query.IProjectQueryJPARepository;
import cloud.tteams.project.project.infrastructure.exception.ProjectNotFoundException;
import cloud.tteams.project.project.infrastructure.repository.hibernate.ProjectEntity;
import cloud.tteams.share.core.domain.rules.RulesChecker;
import cloud.tteams.share.core.domain.service.ILogService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Primary
public class ProjectCommandRepositoryImplementation implements IProjectCommandRepository {

    private final IProjectCommandJPARepository jpaRepository;

    private final IProjectQueryJPARepository readDataJPARepository;

    private final ILogService logService;

    public ProjectCommandRepositoryImplementation(final IProjectCommandJPARepository jpaRepository, IProjectQueryJPARepository readDataJPARepository, ILogService logService) {
        this.jpaRepository = jpaRepository;
        this.readDataJPARepository = readDataJPARepository;
        this.logService = logService;
    }

    @Override
    public Project create(Project project) {
        RulesChecker.checkRule(new ProjectNameMustBeUnique(readDataJPARepository, project.getName(), project.getId()));
        RulesChecker.checkRule(new ProjectStartDateMustBeBeforeEstimatedEndDate(project.getStartDate(), project.getEstimatedEndDate()));
        return jpaRepository
                .save(new ProjectEntity(project))
                .toAggregate();
    }

    @Override
    public Project update(Project project) {
        ProjectEntity entityToUpdate =
                readDataJPARepository.findById(project.getId().getValue()).orElseThrow(ProjectNotFoundException::new);
        Project toUpdateProject = entityToUpdate.toAggregate();
        if (project.getStartDate().getValue() != null) {
            if (project.getEstimatedEndDate().getValue() != null){
                RulesChecker.checkRule(new ProjectStartDateMustBeBeforeEstimatedEndDate(project.getStartDate(), project.getEstimatedEndDate()));
            }
            else {
                RulesChecker.checkRule(new ProjectStartDateMustBeBeforeEstimatedEndDate(project.getStartDate(), toUpdateProject.getEstimatedEndDate()));
            }
        } else if (project.getEstimatedEndDate().getValue() != null) {
            RulesChecker.checkRule(new ProjectStartDateMustBeBeforeEstimatedEndDate(toUpdateProject.getStartDate(), project.getEstimatedEndDate()));
        }
        ProjectEntity newEntity = ProjectEntity.toUpdate(project);
        Field[] fields = entityToUpdate.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object value = attrib.get(newEntity);
                Object valueToUpdate = attrib.get(entityToUpdate);
                if (value != null && !value.equals(valueToUpdate)
                        && attrib.getType().isAssignableFrom(value.getClass())) {
                    attrib.set(entityToUpdate, value);
                }
            }
        } catch (IllegalAccessException e){
            logService.error(e.getMessage(), project, e);
        }
        jpaRepository.save(entityToUpdate);
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
