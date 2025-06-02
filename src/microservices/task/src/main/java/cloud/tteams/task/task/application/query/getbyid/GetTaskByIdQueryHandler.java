package cloud.tteams.task.task.application.query.getbyid;

import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.task.task.application.query.TaskResponse;
import cloud.tteams.task.task.domain.Task;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import cloud.tteams.task.task.domain.valueobject.TaskId;
import org.springframework.stereotype.Component;

@Component
public class GetTaskByIdQueryHandler implements IQueryHandler<GetTaskByIdQuery, TaskResponse> {

    private final ITaskDomainService taskDomainService;

    public GetTaskByIdQueryHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public TaskResponse handle(GetTaskByIdQuery query) {
        TaskId id = new TaskId(query.getId());
        Task task = taskDomainService.findById(id);
        return new TaskResponse(task);
    }
}
