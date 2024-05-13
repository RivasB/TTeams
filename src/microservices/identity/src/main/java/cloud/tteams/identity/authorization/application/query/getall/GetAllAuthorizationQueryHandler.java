package cloud.tteams.identity.authorization.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class GetAllAuthorizationQueryHandler
        implements IQueryHandler<GetAllAuthorizationQuery, MessagePaginatedResponse> {

    private final IAuthorizationService service;

    public GetAllAuthorizationQueryHandler(IAuthorizationService service) {
        this.service = service;
    }

    @Override
    public MessagePaginatedResponse handle(GetAllAuthorizationQuery query) {
        return service.getAll(query.getPageable(), query.getName(), query.getResource(), query.getAction(), query.getState());
    }

}
