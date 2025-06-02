package cloud.tteams.task.task.application.query.getall;

import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import cloud.tteams.task.task.domain.service.ITaskDomainService;
import org.springframework.stereotype.Component;

@Component
public class GetAllTaskQueryHandler implements IQueryHandler<GetAllTaskQuery, MessagePaginatedResponse> {

    private final ITaskDomainService taskDomainService;

    public GetAllTaskQueryHandler(ITaskDomainService taskDomainService) {
        this.taskDomainService = taskDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllTaskQuery query) {
        if (query.getFilters().isEmpty()) {
            return taskDomainService.findAll(query.getPageable());
        }
        else {
            return taskDomainService.findAllFiltered(query.getFilters(), query.getPageable());
        }
    }
}
