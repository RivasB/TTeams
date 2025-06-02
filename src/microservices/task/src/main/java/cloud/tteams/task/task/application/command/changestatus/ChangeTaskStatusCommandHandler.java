package cloud.tteams.task.task.application.command.changestatus;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.stereotype.Component;

@Component
public class ChangeTaskStatusCommandHandler implements ICommandHandler<ChangeTaskStatusCommand> {

    private final ITaskDomainService taskDomainService;

    public ChangeTaskStatusCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(ChangeTaskStatusCommand command) {
        TaskId id = new TaskId(command.getId());
        taskDomainService.changeStatus(id, command.getStatus());
    }
}
