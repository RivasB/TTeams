package cloud.tteams.identity.access.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.access.domain.service.IAccessService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindAccessWithFilterQueryHandler
        implements IQueryHandler<FindAccessWithFilterQuery, MessagePaginatedResponse> {

    private final IAccessService accessService;

    public FindAccessWithFilterQueryHandler(IAccessService accessService) {
        this.accessService = accessService;
    }

    @Override
    public MessagePaginatedResponse handle(FindAccessWithFilterQuery query) {

        return accessService.getPaginatedAccess(query.getPageable(), query.getDescription(), query.getCode(), query.getResource());
    }

}
