package ec.gob.registrocivil.identity.access.application.query.getall;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.access.domain.service.IAccessService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
