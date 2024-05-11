package cloud.tteams.identity.organization.application.query.getall;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.organization.domain.service.IAgencyService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

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
