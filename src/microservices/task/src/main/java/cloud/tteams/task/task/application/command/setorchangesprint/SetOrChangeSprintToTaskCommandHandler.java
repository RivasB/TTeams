package cloud.tteams.task.task.application.command.setorchangesprint;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import cloud.tteams.task.task.domain.valueobject.TaskSprint;
import org.springframework.stereotype.Component;

@Component
public class SetOrChangeSprintToTaskCommandHandler implements ICommandHandler<SetOrChangeSprintToTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public SetOrChangeSprintToTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(SetOrChangeSprintToTaskCommand command) {
        TaskId id = new TaskId(command.getId());
        TaskSprint sprint = new TaskSprint(command.getSprint());
        taskDomainService.setOrChangeSprint(id, sprint);
    }
}
