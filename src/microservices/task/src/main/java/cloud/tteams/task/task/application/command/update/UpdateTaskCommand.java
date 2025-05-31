package cloud.tteams.task.task.application.command.update;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.task.task.application.query.TaskReferenceResponse;
import cloud.tteams.task.task.domain.valueobject.TaskPriority;
import cloud.tteams.task.task.domain.valueobject.TaskType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public class UpdateTaskCommand implements ICommand {

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

    public UpdateTaskCommand(UpdateTaskRequest request) {
        this.id = request.getId() != null ? request.getId() : null;
        this.name = request.getName() != null ? request.getName() : null;
        this.description = request.getDescription() != null ? request.getDescription() : null;
        this.estimatedEndDate = request.getEstimatedEndDate() != null ? request.getEstimatedEndDate() : null;
        this.project = request.getProject() != null ? request.getProject() : null;
        this.reportingUser = request.getReportingUser() != null ? request.getReportingUser() : null;
        this.parentTask = request.getParentTask() != null ? request.getParentTask() : null;
        this.blockedBy = request.getBlockedBy() != null ? request.getBlockedBy() : null;
        this.effort = request.getEffort() != null ? request.getEffort() : null;
        this.type = request.getType() != null ? request.getType() : null;
        this.priority = request.getPriority() != null ? request.getPriority() : null;
        this.tags = request.getTags() != null ? request.getTags() : null;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "UPDATED");
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

    public UUID getParentTask() {
        return parentTask;
    }

    public UUID getBlockedBy() {
        return blockedBy;
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
