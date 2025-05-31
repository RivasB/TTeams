package cloud.tteams.task.task.application.command.delete;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.stereotype.Component;

@Component
public class DeleteTaskCommandHandler implements ICommandHandler<DeleteTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public DeleteTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(DeleteTaskCommand command) {
        TaskId id = new TaskId(command.getId());
        taskDomainService.delete(id);
    }
}
