package cloud.tteams.task.task.application.query;

import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskStatus;
import cloud.tteams.task.task.domain.valueobject.TaskType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class TaskResponse implements IResponse {

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
        this.id = task.getId() != null ? task.getId().value() : null;
        this.name = task.getName() != null ? task.getName().value() : null;
        this.description = task.getDescription() != null ? task.getDescription().value() : null;
        this.createdDate = task.getCreatedDate() != null ? task.getCreatedDate().value() : null;
        this.startDate = task.getStartDate() != null ? task.getStartDate().value() : null;
        this.estimatedEndDate = task.getEstimatedEndDate() != null ? task.getEstimatedEndDate().value() : null;
        this.completionDate = task.getCompletionDate() != null && task.getCompletionDate().value() != null ? task.getCompletionDate().value() : null;
        this.loggedTime = task.getLoggedTime() != null ? task.getLoggedTime().value() : null;
        this.project = task.getProject() != null ? task.getProject().value() : null;
        this.assignedUser = task.getAssignedUser() != null ? task.getAssignedUser().value() : null;
        this.reportingUser = task.getReportingUser() != null ? task.getReportingUser().value() : null;
        this.parentTask = task.getParentTask() != null ? new TaskReferenceResponse(task.getParentTask()) : null;
        this.blockedBy = task.getBlockedBy() != null ? new TaskReferenceResponse(task.getBlockedBy()) : null;
        this.sprint = task.getSprint() != null ? task.getSprint().value() : null;
        this.effort = task.getEffort() != null ? task.getEffort().value() : null;
        this.type = task.getType() != null ? task.getType() : null;
        this.status = task.getStatus() != null ? task.getStatus() : null;
        this.priority = task.getPriority() != null ? task.getPriority() : null;
        this.tags = task.getTags() != null ? task.getTags().getValue() : null;
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

}