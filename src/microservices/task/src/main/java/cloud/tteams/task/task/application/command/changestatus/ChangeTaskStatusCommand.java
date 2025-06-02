package cloud.tteams.task.task.application.command.changestatus;

import cloud.tteams.share.core.application.command.CommandMessage;
import cloud.tteams.share.core.domain.bus.command.ICommand;
import cloud.tteams.share.core.domain.bus.command.ICommandMessage;
import cloud.tteams.task.task.domain.valueobject.TaskStatus;

import java.util.UUID;

public class ChangeTaskStatusCommand implements ICommand {

    private final UUID id;
    private final TaskStatus status;

    public ChangeTaskStatusCommand(UUID id, TaskStatus status) {
        this.id = id;
        this.status = status;
    }

    @Override
    public ICommandMessage getMessage() {
        return new CommandMessage(this.id, "CHANGE_TASK_STATUS");
    }

    public TaskStatus getStatus() {
        return status;
    }

    public UUID getId() {
        return id;
    }
}
