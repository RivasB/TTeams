package cloud.tteams.task.task.application.command.update;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.*;
import cloud.tteams.task.task.infrastructure.exception.TaskNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskCommandHandler implements ICommandHandler<UpdateTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public UpdateTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(UpdateTaskCommand command) {
        Task parentTask = null;
        Task blockedByTask = null;
        if (command.getParentTask() != null) {
            try {
                parentTask = taskDomainService.findById(new TaskId(command.getParentTask()));
            } catch (Exception e) {
                throw new TaskNotFoundException("Parent task not found with ID: " + command.getParentTask());
            }
        }
        if (command.getBlockedBy() != null) {
            try {
                blockedByTask = taskDomainService.findById(new TaskId(command.getBlockedBy()));
            } catch (Exception e) {
                throw new TaskNotFoundException("Blocked by task not found with ID: " + command.getBlockedBy());
            }
        }
        Task task = new Task(
            command.getId() != null ? new TaskId(command.getId()) : null,
            command.getName() != null ? new TaskName(command.getName()) : null,
            command.getDescription() != null ? new TaskDescription(command.getDescription()) : null,
            null, // TaskCreatedDate no se actualiza aquí
            null, // TaskStartDate no se actualiza aquí
            command.getEstimatedEndDate() != null ? new TaskEstimatedEndDate(command.getEstimatedEndDate()) : null,
            null, // TaskCompletionDate no se actualiza aquí
            null, // TaskLoggedTime no se actualiza aquí
            command.getProject() != null ? new TaskProject(command.getProject()) : null,
            null, // TaskAssignedUser no se actualiza aquí
            command.getReportingUser() != null ? new TaskReportingUser(command.getReportingUser()) : null,
            parentTask,
            blockedByTask,
            null, // TaskSprint no se actualiza aquí
            command.getEffort() != null ? new TaskEstimatedEffort(command.getEffort()) : null,
            command.getType(),
            null, // TaskStatus no se actualiza aquí
            command.getPriority(),
            command.getTags() != null ? new TaskTags(command.getTags()) : null
        );
        taskDomainService.update(task);
    }
}
