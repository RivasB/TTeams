package cloud.tteams.task.task.application.command.update;

import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class UpdateTaskRequest {

    @NotNull(message = "Task id can not be null on update")
    private final UUID id;
    private final String name;
    private final String description;
    private final LocalDate estimatedEndDate;
    private final UUID project;
    private final UUID reportingUser;
    private final UUID parentTask;
    private final UUID blockedBy;
    private final Integer effort;
    private final TaskType type;
    private final TaskPriority priority;
    private final Collection<String> tags;

    public UpdateTaskRequest(UUID id, String name, String description, LocalDate estimatedEndDate, UUID project, UUID reportingUser, UUID parentTask, UUID blockedBy, Integer effort, TaskType type, TaskPriority priority, Collection<String> tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.estimatedEndDate = estimatedEndDate;
        this.project = project;
        this.reportingUser = reportingUser;
        this.parentTask = parentTask;
        this.blockedBy = blockedBy;
        this.effort = effort;
        this.type = type;
        this.priority = priority;
        this.tags = tags;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public UUID getProject() {
        return project;
    }

    public UUID getReportingUser() {
        return reportingUser;
    }

    public UUID getBlockedBy() {
        return blockedBy;
    }

    public UUID getParentTask() {
        return parentTask;
    }

    public Integer getEffort() {
        return effort;
    }

    public TaskType getType() {
        return type;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public Collection<String> getTags() {
        return tags;
    }
}
