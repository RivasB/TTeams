package cloud.tteams.project.project.application.query.getall;

import cloud.tteams.project.project.domain.service.IProjectDomainService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;
import org.springframework.stereotype.Component;

@Component
public class GetAllProjectQueryHandler implements IQueryHandler<GetAllProjectQuery, MessagePaginatedResponse> {

    private final IProjectDomainService projectDomainService;

    public GetAllProjectQueryHandler(IProjectDomainService projectDomainService) {
        this.projectDomainService = projectDomainService;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllProjectQuery query) {
        return projectDomainService.findAll(query.getPageable(), query.getFilters());
    }
}
