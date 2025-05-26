package cloud.tteams.task.task.application.command.create;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskType;

import java.util.Collection;
import java.util.UUID;

public class CreateTaskCommand implements ICommand {

    private final UUID id;
    private final String name;
    private final String description;
    private final UUID project;
    private final TaskType type;
    private final TaskPriority priority;
    private final Collection<String> tags;
    private final UUID assignedUser;
    private final UUID parentTask;
    private final UUID sprint;
    private final Integer estimatedEffort;

    public CreateTaskCommand(CreateTaskRequest request) {
        this.id = UUID.randomUUID();
        this.name = request.getName() != null ? request.getName() : null;
        this.description = request.getDescription() != null ? request.getDescription() : null;
        this.project = request.getProject() != null ? request.getProject() : null;
        this.type = request.getType() != null ? request.getType() : null;
        this.priority = request.getPriority() != null ? request.getPriority() : null;
        this.tags = request.getTags() != null ? request.getTags() : null;
        this.assignedUser = request.getAssignedUser() != null ? request.getAssignedUser() : null;
        this.parentTask = request.getParentTask() != null ? request.getParentTask() : null;
        this.sprint = request.getSprint() != null ? request.getSprint() : null;
        this.estimatedEffort = request.getEstimatedEffort() != null ? request.getEstimatedEffort() : null;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "CREATED");
    }
}
