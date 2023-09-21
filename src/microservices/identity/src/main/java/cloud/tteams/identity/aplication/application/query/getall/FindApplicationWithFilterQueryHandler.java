package cloud.tteams.identity.aplication.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.aplication.domain.service.IAplicationService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindApplicationWithFilterQueryHandler
        implements IQueryHandler<FindApplicationWithFilterQuery, MessagePaginatedResponse> {

    private final IAplicationService aplicationService;

    public FindApplicationWithFilterQueryHandler(IAplicationService aplicationService) {
        this.aplicationService = aplicationService;
    }

    @Override
    public MessagePaginatedResponse handle(FindApplicationWithFilterQuery query) {

        return aplicationService.getPaginatedAplication(query.getPageable(), query.getFilter());
    }

}
