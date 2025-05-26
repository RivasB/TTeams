package cloud.tteams.task.task.application.command.create;

import cloud.tteams.share.core.domain.bus.command.ICommandHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskCommandHandler implements ICommandHandler<CreateTaskCommand> {

    private final ITaskDomainService taskDomainService;

    public CreateTaskCommandHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public void handle(CreateTaskCommand command) {

    }
}
