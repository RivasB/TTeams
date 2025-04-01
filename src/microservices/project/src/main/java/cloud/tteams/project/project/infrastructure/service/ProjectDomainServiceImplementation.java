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
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProjectDomainServiceImplementation implements IProjectDomainService {

    private final IProjectCommandRepository commandRepository;

    private final IProjectQueryRepository queryRepository;

    private final IEventService<Project> eventService;

    private final Log logger = LogFactory.getLog(this.getClass());

    @Value("${kafka.messenger.notifications:true}")
    private boolean messengerIsActive;

    public ProjectDomainServiceImplementation(IProjectCommandRepository commandRepository, IProjectQueryRepository queryRepository,
                                              IEventService<Project> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void create(Project project) {
        Project created = commandRepository.create(project);
        logger.info(
                String.format("New Project created with: Id: %s and Name: %s  by the user: %s",
                        created.getId().getValue(),
                        created.getName(), UserContext.getUserSession().getUsername()));
        publishEvent(created, EventType.CREATED);
    }

    @Override
    @Transactional
    public void update(Project project) {
        Project updated = commandRepository.update(project);
        logger.info(
                String.format("Project updated with: Id: %s and Name: %s  by the user: %s",
                        updated.getId().getValue(),
                        updated.getName(), UserContext.getUserSession().getUsername()));
        publishEvent(updated, EventType.UPDATED);
    }

    @Override
    public void delete(ProjectId projectId) {
        Project deleted = commandRepository.delete(projectId);
        logger.info(
                String.format("Project deleted with: Id: %s and Name: %s  by the user: %s",
                        deleted.getId().getValue(),
                        deleted.getName(), UserContext.getUserSession().getUsername()));
        publishEvent(deleted, EventType.DELETED);
    }

    @Override
    public Project findById(ProjectId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    private void publishEvent(Project data, EventType type){
        if (messengerIsActive){
            switch(type) {
                case CREATED:
                    eventService.create(data);
                    break;
                case UPDATED:
                    eventService.update(data);
                    break;
                case DELETED:
                    eventService.delete(data);
                    break;
                default:
            }
        }
    }

}
