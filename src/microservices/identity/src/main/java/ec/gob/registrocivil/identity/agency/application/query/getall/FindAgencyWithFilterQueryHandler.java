package ec.gob.registrocivil.identity.agency.application.query.getall;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindAgencyWithFilterQueryHandler
        implements IQueryHandler<FindAgencyWithFilterQuery, MessagePaginatedResponse> {

    private final IAgencyService agencyService;

    public FindAgencyWithFilterQueryHandler(IAgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    public MessagePaginatedResponse handle(FindAgencyWithFilterQuery query) {

        return agencyService.getPaginatedAgency(query.getPageable(), query.getName(), query.getProvince(), query.getCanton(), query.getDescription(), query.getLatitude(), query.getLongitude(), query.getState(), query.getFilter());
    }

}
