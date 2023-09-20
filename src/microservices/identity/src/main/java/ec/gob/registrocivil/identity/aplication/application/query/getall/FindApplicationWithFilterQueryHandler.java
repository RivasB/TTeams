package ec.gob.registrocivil.identity.aplication.application.query.getall;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.aplication.domain.service.IAplicationService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
