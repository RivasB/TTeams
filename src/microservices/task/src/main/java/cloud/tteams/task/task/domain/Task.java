package cloud.tteams.task.task.domain;

import cloud.tteams.task.task.domain.valueobject.*;

public class Task {

    private final TaskId id;

    private final TaskName name;

    private final TaskDescription description;

    private final TaskCreatedDate createdDate;

    private final TaskStartDate startDate;

    private final TaskEstimatedEndDate estimatedEndDate;

    private final TaskCompletionDate completionDate;

    private final TaskLoggedTime loggedTime;

    private final TaskProject project;

    private final TaskAssignedUser assignedUser;

    private final TaskReportingUser reportingUser;

    private final TaskReference parentTask;

    private final TaskReference blockedBy;

    private final TaskSprint sprint;

    private final TaskEstimatedEffort effort;

    private final TaskType type;

    private final TaskStatus status;

    private final TaskPriority priority;

    private final TaskTags tags;

    public Task(TaskId id, TaskName name, TaskDescription description, TaskCreatedDate createdDate, TaskStartDate startDate, TaskEstimatedEndDate estimatedEndDate, TaskCompletionDate completionDate, TaskLoggedTime loggedTime, TaskProject project, TaskAssignedUser assignedUser, TaskReportingUser reportingUser, TaskReference parentTask, TaskReference blockedBy, TaskSprint sprint, TaskEstimatedEffort effort, TaskType type, TaskStatus status, TaskPriority priority, TaskTags tags) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.completionDate = completionDate;
        this.loggedTime = loggedTime;
        this.project = project;
        this.assignedUser = assignedUser;
        this.reportingUser = reportingUser;
        this.parentTask = parentTask;
        this.blockedBy = blockedBy;
        this.sprint = sprint;
        this.effort = effort;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.tags = tags;
    }

    public TaskId getId() {
        return id;
    }

    public TaskName getName() {
        return name;
    }

    public TaskLoggedTime getLoggedTime() {
        return loggedTime;
    }

    public TaskProject getProject() {
        return project;
    }

    public TaskType getType() {
        return type;
    }

    public TaskSprint getSprint() {
        return sprint;
    }

    public TaskCompletionDate getCompletionDate() {
        return completionDate;
    }

    public TaskEstimatedEffort getEffort() {
        return effort;
    }

    public TaskCreatedDate getCreatedDate() {
        return createdDate;
    }

    public TaskDescription getDescription() {
        return description;
    }

    public TaskStartDate getStartDate() {
        return startDate;
    }

    public TaskEstimatedEndDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskReportingUser getReportingUser() {
        return reportingUser;
    }

    public TaskReference getParentTask() {
        return parentTask;
    }

    public TaskReference getBlockedBy() {
        return blockedBy;
    }

    public TaskAssignedUser getAssignedUser() {
        return assignedUser;
    }

    public TaskTags getTags() {
        return tags;
    }
}
