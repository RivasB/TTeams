package cloud.tteams.project.project.infrastructure.service;


import cloud.tteams.project.project.domain.Project;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.project.project.domain.ProjectId;
import cloud.tteams.project.project.domain.repository.IProjectCommandRepository;
import cloud.tteams.project.project.domain.repository.IProjectQueryRepository;
import cloud.tteams.project.project.domain.service.IProjectDomainService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class ProjectDomainServiceImplementation implements IProjectDomainService {

    private final IProjectCommandRepository commandRepository;

    private final IProjectQueryRepository queryRepository;

    private final IEventService<Project> eventService;

    private final Log logger = LogFactory.getLog(this.getClass());

    @Value("${kafka.messenger.project:false}")
    private boolean messengerIsActive;

    public ProjectDomainServiceImplementation(IProjectCommandRepository commandRepository, IProjectQueryRepository queryRepository,
                                              IEventService<Project> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void create(Project project) {
        commandRepository.create(project);
        publishEvent(project, EventType.CREATED);
    }

    @Override
    public void update(Project project) {
        Project toUpdateProject = findById(project.getId());
        Field[] fields = project.getClass().getDeclaredFields();
        try  {
            for (Field attrib : fields) {
                attrib.setAccessible(true);
                Object valueStation = attrib.get(project);
                Object valueToUpdateStation = attrib.get(toUpdateProject);
                if (valueStation != null && !valueStation.equals(valueToUpdateStation)
                        && attrib.getType().isAssignableFrom(valueStation.getClass())) {
                    attrib.set(toUpdateProject, valueStation);
                }
            }
        } catch (IllegalAccessException e){
            logger.error(e.getMessage());
        }
        commandRepository.update(toUpdateProject);
        publishEvent(toUpdateProject, EventType.UPDATED);
    }

    @Override
    public void delete(ProjectId projectId) {
        Project project = this.findById(projectId);
        commandRepository.delete(projectId);
        publishEvent(project, EventType.DELETED);
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
                    eventService.publish(data);
                    break;
                case UPDATED:
                    eventService.update(data);
                    break;
                case DELETED:
                    eventService.delete(data);
                    break;
                default:
                    // do nothing
            }
        }
    }

}
