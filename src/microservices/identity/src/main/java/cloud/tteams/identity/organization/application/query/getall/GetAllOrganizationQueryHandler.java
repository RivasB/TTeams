package cloud.tteams.identity.organization.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class GetAllOrganizationQueryHandler
        implements IQueryHandler<GetAllOrganizationQuery, MessagePaginatedResponse> {

    private final IOrganizationService service;

    public GetAllOrganizationQueryHandler(IOrganizationService service) {
        this.service = service;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllOrganizationQuery query) {
        return service.getAll(query.getPageable(), query.getName(), query.getDescription(), query.getContact(),
                query.getState());
    }

}
