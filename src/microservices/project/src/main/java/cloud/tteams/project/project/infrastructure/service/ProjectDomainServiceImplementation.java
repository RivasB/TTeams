package cloud.tteams.project.project.infrastructure.service;


import cloud.tteams.project.project.domain.Project;
import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.project.project.domain.valueobject.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectCommandRepository;
import cloud.tteams.project.project.domain.repository.IProjectQueryRepository;
import cloud.tteams.project.project.domain.service.IProjectDomainService;
import cloud.tteams.share.core.domain.service.ILogService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProjectDomainServiceImplementation implements IProjectDomainService {

    private final IProjectCommandRepository commandRepository;

    private final IProjectQueryRepository queryRepository;

    private final IEventService<Project> eventService;

    private final ILogService logService;

    @Value("${kafka.messenger.notifications:true}")
    private boolean messengerIsActive;

    public ProjectDomainServiceImplementation(IProjectCommandRepository commandRepository, IProjectQueryRepository queryRepository,
                                              IEventService<Project> eventService, ILogService logService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
        this.logService = logService;
    }

    @Override
    public void create(Project project) {
        Project created = commandRepository.create(project);
        logService.info(String.format("New Project created with: Id: %s and Name: %s  by the user: %s",
                created.getId().getValue(),
                created.getName(), UserContext.getUserSession().getUsername()), created);
        publishEvent(created, EventType.CREATED);
    }

    @Override
    @Transactional
    public void update(Project project) {
        Project updated = commandRepository.update(project);
        logService.info(
                String.format("Project updated with: Id: %s and Name: %s  by the user: %s",
                        updated.getId().getValue(),
                        updated.getName(), UserContext.getUserSession().getUsername()), updated);
        publishEvent(updated, EventType.UPDATED);
    }

    @Override
    public void delete(ProjectId projectId) {
        Project deleted = commandRepository.delete(projectId);
        logService.info(
                String.format("Project deleted with: Id: %s and Name: %s  by the user: %s",
                        deleted.getId().getValue(),
                        deleted.getName(), UserContext.getUserSession().getUsername()), deleted);
        publishEvent(deleted, EventType.DELETED);
    }

    @Override
    public Project findById(ProjectId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable, Object filters) {
        return queryRepository.findAll(pageable, filters);
    }

    private void publishEvent(Project data, EventType type){
        if (messengerIsActive){
                    eventService.publish(type, data);
        }
    }

}
