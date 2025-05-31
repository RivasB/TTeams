package cloud.tteams.task.task.infrastructure.service;


import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.rules.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.share.core.domain.service.ILogService;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.repository.ITaskCommandRepository;
import cloud.tteams.task.task.domain.repository.ITaskQueryRepository;
import cloud.tteams.task.task.domain.rules.AssignedUserMustBelongToTaskProject;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ProjectDomainServiceImplementation implements ITaskDomainService {

    private final ITaskCommandRepository commandRepository;

    private final ITaskQueryRepository queryRepository;

    private final IEventService<Task> eventService;

    private final ILogService logService;

    public ProjectDomainServiceImplementation(ITaskCommandRepository commandRepository, ITaskQueryRepository queryRepository,
                                              IEventService<Task> eventService, ILogService logService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
        this.logService = logService;
    }

    @Override
    public void create(Task task) {
        if (task.getAssignedUser() == null) {
            RulesChecker.checkRule(new AssignedUserMustBelongToTaskProject(task.getProject(), task.getAssignedUser()));
        }
        commandRepository.create(task);
        eventService.publish(EventType.CREATED, task);
        logService.info(String.format("New Task created with: Id: %s and Name: %s  by the user: %s",
                task.getId().getValue(),
                task.getName().getValue(), UserContext.getUserSession().getUsername()), task);
    }

    @Override
    public void update(Task task) {
        commandRepository.update(task);
        eventService.publish(EventType.UPDATED, task);
        logService.info(String.format("Task with: Id: %s and Name: %s  was updated by the user: %s",
                task.getId().getValue(),
                task.getName().getValue(), UserContext.getUserSession().getUsername()), task);
    }

    @Override
    public void delete(TaskId taskId) {
        Task task = this.findById(taskId);
        commandRepository.delete(taskId);
        eventService.publish(EventType.CREATED, task);
        logService.info(String.format("Task with: Id: %s and Name: %s  was deleted by the user: %s",
                task.getId().getValue(),
                task.getName().getValue(), UserContext.getUserSession().getUsername()), task);
    }

    @Override
    public void assign(TaskId id, TaskAssignedUser user) {
        Task task = this.findById(id);
        RulesChecker.checkRule(new AssignedUserMustBelongToTaskProject(task.getProject(), user));
        commandRepository.assign(id, user);
        eventService.publish(EventType.ASSIGNED, task);
        logService.info(String.format("Task with: Id: %s and Name: %s  was assigned to user with uuid: %s by: %s",
                task.getId().getValue(),
                user.getValue(),
                task.getName().getValue(), UserContext.getUserSession().getUsername()), task);

    }

    @Override
    public void changeStatus(TaskId id, TaskStatus status) {

    }

    @Override
    public void logTime(TaskId id, TaskLoggedTime time) {

    }

    @Override
    public void setEffort(TaskId id, TaskEstimatedEffort effort) {

    }

    @Override
    public void setOrChangeSprint(TaskId taskId, TaskSprint sprint) {

    }

    @Override
    public Task findById(TaskId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

}
