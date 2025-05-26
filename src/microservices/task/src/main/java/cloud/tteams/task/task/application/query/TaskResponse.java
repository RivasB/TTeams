package cloud.tteams.task.task.application.query;

import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskStatus;
import cloud.tteams.task.task.domain.valueobject.TaskType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class TaskResponse {

    private final UUID id;
    private final String name;
    private final String description;
    private final LocalDate createdDate;
    private final LocalDate startDate;
    private final LocalDate estimatedEndDate;
    private final LocalDate completionDate;
    private final Integer loggedTime;
    private final UUID project;
    private final UUID assignedUser;
    private final UUID reportingUser;
    private final TaskReferenceResponse parentTask;
    private final TaskReferenceResponse blockedBy;
    private final UUID sprint;
    private final Integer effort;
    private final TaskType type;
    private final TaskStatus status;
    private final TaskPriority priority;
    private final Collection<String> tags;

    public TaskResponse(Task task) {
        this.id = task.getId().value();
        this.name = task.getName().value();
        this.description = task.getDescription().value();
        this.createdDate = task.getCreatedDate().value();
        this.startDate = task.getStartDate().value();
        this.estimatedEndDate = task.getEstimatedEndDate().value();
        this.completionDate = task.getCompletionDate().value() != null ? task.getCompletionDate().value() : null;
        this.loggedTime = task.getLoggedTime().value();
        this.project = task.getProject().value();
        this.assignedUser = task.getAssignedUser().value();
        this.reportingUser = task.getReportingUser().value();
        this.parentTask = task.getParentTask() != null ? new TaskReferenceResponse(task.getParentTask()) : null;
        this.blockedBy = task.getBlockedBy() != null ? new TaskReferenceResponse(task.getBlockedBy()) : null;
        this.sprint = task.getSprint() != null ? task.getSprint().value() : null;
        this.effort = task.getEffort() != null ? task.getEffort().value() : null;
        this.type = task.getType();
        this.status = task.getStatus();
        this.priority = task.getPriority();
        this.tags = task.getTags().getValue();
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public Integer getLoggedTime() {
        return loggedTime;
    }

    public UUID getProject() {
        return project;
    }

    public UUID getAssignedUser() {
        return assignedUser;
    }

    public UUID getReportingUser() {
        return reportingUser;
    }

    public TaskReferenceResponse getParentTask() {
        return parentTask;
    }

    public TaskReferenceResponse getBlockedBy() {
        return blockedBy;
    }

    public UUID getSprint() {
        return sprint;
    }

    public Integer getEffort() {
        return effort;
    }

    public TaskType getType() {
        return type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public Collection<String> getTags() {
        return tags;
    }

    // Getters for all fields can be added here if needed
}