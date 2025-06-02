package cloud.tteams.task.task.application.command.seteffort;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskEstimatedEffort;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.stereotype.Component;

@Component
public class SetEffortInTaskCommandHandler implements ICommandHandler<SetEffortInTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public SetEffortInTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(SetEffortInTaskCommand command) {
        TaskId id = new TaskId(command.getId());
        TaskEstimatedEffort effort = new TaskEstimatedEffort(command.getEffort());
        taskDomainService.setEffort(id, effort);
    }
}
