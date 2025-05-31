package cloud.tteams.task.task.application.command.create;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.*;
import cloud.tteams.task.task.infrastructure.exception.TaskNotFoundException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreateTaskCommandHandler implements ICommandHandler<CreateTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public CreateTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(CreateTaskCommand command) {
        Task parentTask = null;
        if (command.getParentTask() != null) {
            try {
                parentTask = taskDomainService.findById(new TaskId(command.getParentTask()));
            } catch (Exception e) {
                throw new TaskNotFoundException("Parent task not found with ID: " + command.getParentTask());
            }
        }
        //TODO: si ya viene con usuario asignado verificar que el proyecto existe y que el usuario asignado es parte del proyecto
        Task task = new Task(
            new TaskId(command.getId()),
            new TaskName(command.getName()),
            new TaskDescription(command.getDescription()),
            new TaskCreatedDate(LocalDate.now()),
            null, // startDate
            null, // estimatedEndDate
            null, // completionDate
            new TaskLoggedTime(0), // loggedTime inicial
            new TaskProject(command.getProject()),
            command.getAssignedUser() != null ? new TaskAssignedUser(command.getAssignedUser()) : null,
            new TaskReportingUser(UserContext.getUserSession().getUserId()), // reportingUser
            parentTask,
            null, // blockedBy
            command.getSprint() != null ? new TaskSprint(command.getSprint()) : null,
            command.getEstimatedEffort() != null ? new TaskEstimatedEffort(command.getEstimatedEffort()) : null,
            command.getType(),
            TaskStatus.PENDING, // default status
            command.getPriority(),
            command.getTags() != null ? new TaskTags(command.getTags()) : null
        );
        taskDomainService.create(task);
    }
}
