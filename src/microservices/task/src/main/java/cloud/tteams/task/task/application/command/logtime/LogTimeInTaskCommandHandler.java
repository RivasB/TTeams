package cloud.tteams.task.task.application.command.logtime;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskEstimatedEffort;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import cloud.tteams.task.task.domain.valueobject.TaskLoggedTime;
import org.springframework.stereotype.Component;

@Component
public class LogTimeInTaskCommandHandler implements ICommandHandler<LogTimeInTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public LogTimeInTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(LogTimeInTaskCommand command) {
        TaskId id = new TaskId(command.getId());
        TaskLoggedTime loggedTime = new TaskLoggedTime(command.getHours());
        taskDomainService.logTime(id, loggedTime);
    }
}
