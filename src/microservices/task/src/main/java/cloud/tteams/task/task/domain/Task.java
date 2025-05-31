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

    private final Task parentTask;

    private final Task blockedBy;

    private final TaskSprint sprint;

    private final TaskEstimatedEffort effort;

    private final TaskType type;

    private final TaskStatus status;

    private final TaskPriority priority;

    private final TaskTags tags;


    public Task(TaskId id, TaskName name, TaskDescription description, TaskCreatedDate createdDate, TaskStartDate startDate, TaskEstimatedEndDate estimatedEndDate, TaskCompletionDate completionDate, TaskLoggedTime loggedTime, TaskProject project, TaskAssignedUser assignedUser, TaskReportingUser reportingUser, Task parentTask, Task blockedBy, TaskSprint sprint, TaskEstimatedEffort effort, TaskType type, TaskStatus status, TaskPriority priority, TaskTags tags) {
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

    public TaskDescription getDescription() {
        return description;
    }

    public TaskCreatedDate getCreatedDate() {
        return createdDate;
    }

    public TaskStartDate getStartDate() {
        return startDate;
    }

    public TaskEstimatedEndDate getEstimatedEndDate() {
        return estimatedEndDate;
    }

    public TaskCompletionDate getCompletionDate() {
        return completionDate;
    }

    public TaskLoggedTime getLoggedTime() {
        return loggedTime;
    }

    public TaskProject getProject() {
        return project;
    }

    public TaskAssignedUser getAssignedUser() {
        return assignedUser;
    }

    public TaskReportingUser getReportingUser() {
        return reportingUser;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public Task getBlockedBy() {
        return blockedBy;
    }

    public TaskSprint getSprint() {
        return sprint;
    }

    public TaskEstimatedEffort getEffort() {
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

    public TaskTags getTags() {
        return tags;
    }
}
