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
import cloud.tteams.task.task.domain.rules.OnlyTheAssignedUserCanLogTime;
import cloud.tteams.task.task.domain.rules.SprintMustExistAndNotBeClosed;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Map;

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
    public void delete(TaskId id) {
        Task task = this.findById(id);
        commandRepository.delete(id);
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
                task.getName().getValue(),
                user.getValue(), UserContext.getUserSession().getUsername()), task);

    }

    @Override
    public void changeStatus(TaskId id, TaskStatus status) {
        Task task = this.findById(id);
        commandRepository.changeStatus(id, status);
        eventService.publish(EventType.UPDATED, task);
        logService.info(String.format("Task with: Id: %s and Name: %s change his status from: %s to: %s by: %s",
                task.getId().getValue(),
                task.getName().getValue(),
                task.getStatus().name(),
                status, UserContext.getUserSession().getUsername()), task);
    }

    @Override
    public void logTime(TaskId id, TaskLoggedTime time) {
        Task task = this.findById(id);
        RulesChecker.checkRule(new OnlyTheAssignedUserCanLogTime(task.getAssignedUser()));
        commandRepository.logTime(id, time);
        eventService.publish(EventType.UPDATED, task);
        logService.info(String.format("The user %s log time in Task with: Id: %s and Name: %s",
                UserContext.getUserSession().getUsername(),
                task.getId().getValue(),
                task.getName().getValue()), task);
    }

    @Override
    public void setEffort(TaskId id, TaskEstimatedEffort effort) {
        Task task = this.findById(id);
        commandRepository.setEffort(id, effort);
        eventService.publish(EventType.UPDATED, task);
        logService.info(String.format("The user %s set estimated effort on Task with: Id: %s and Name: %s",
                UserContext.getUserSession().getUsername(),
                task.getId().getValue(),
                task.getName().getValue()), task);
    }

    @Override
    public void setOrChangeSprint(TaskId id, TaskSprint sprint) {
        Task task = this.findById(id);
        RulesChecker.checkRule(new SprintMustExistAndNotBeClosed(sprint));
        commandRepository.setOrChangeSprint(id, sprint);
        eventService.publish(EventType.UPDATED, task);
        logService.info(String.format("The user %s move Task with: Id: %s and Name: %s to Sprint: %s",
                UserContext.getUserSession().getUsername(),
                task.getId().getValue(),
                task.getName().getValue(),
                sprint.value()), task);
    }

    @Override
    public Task findById(TaskId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse findAll(Pageable pageable) {
        return queryRepository.findAll(pageable);
    }

    @Override
    public MessagePaginatedResponse findAllFiltered(Map<String, Object> filters, Pageable pageable) {
        return queryRepository.findAllFiltered(filters, pageable);
    }

}
