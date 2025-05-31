package cloud.tteams.task.task.application.command.assign;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskAssignedUser;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.stereotype.Component;

@Component
public class AssignTaskCommandHandler implements ICommandHandler<AssignTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public AssignTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(AssignTaskCommand command) {
        TaskId id = new TaskId(command.getId());
        TaskAssignedUser assignedUser = command.getUserId() != null
                ? new TaskAssignedUser(command.getUserId()) : null;
        taskDomainService.assign(id, assignedUser);
    }
}
