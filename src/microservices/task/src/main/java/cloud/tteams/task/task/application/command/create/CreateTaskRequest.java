package cloud.tteams.task.task.application.command.create;

import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Collection;
import java.util.UUID;

public class CreateTaskRequest {

    @NotBlank(message = "Task name cannot be blank")
    private final String name;
    private final String description;
    @NotNull(message = "Project ID cannot be null")
    private final UUID project;
    @NotNull(message = "Task type cannot be null")
    private final TaskType type;
    private final TaskPriority priority;
    private final Collection<String> tags;
    private final UUID assignedUser;
    private final UUID parentTask;
    private final UUID sprint;
    private final Integer estimatedEffort;

    public CreateTaskRequest(
            String name,
            String description,
            UUID project,
            TaskType type, TaskPriority priority,
            Collection<String> tags,
            UUID assignedUser,
            UUID parentTask,
            UUID sprint,
            Integer estimatedEffort
    ) {
        this.name = name;
        this.description = description;
        this.project = project;
        this.type = type;
        this.priority = priority;
        this.tags = tags;
        this.assignedUser = assignedUser;
        this.parentTask = parentTask;
        this.sprint = sprint;
        this.estimatedEffort = estimatedEffort;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getProject() {
        return project;
    }

    public TaskType getType() {
        return type;
    }

    public Collection<String> getTags() {
        return tags;
    }

    public UUID getAssignedUser() {
        return assignedUser;
    }

    public UUID getParentTask() {
        return parentTask;
    }

    public UUID getSprint() {
        return sprint;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public Integer getEstimatedEffort() {
        return estimatedEffort;
    }
}
