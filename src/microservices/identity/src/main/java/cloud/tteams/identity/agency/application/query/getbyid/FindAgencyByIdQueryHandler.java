package cloud.tteams.identity.agency.application.query.getbyid;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.identity.agency.domain.AgencyId;
import cloud.tteams.identity.agency.domain.service.IAgencyService;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindAgencyByIdQueryHandler implements IQueryHandler<FindAgencyByIdQuery, FindAgencyByIdResponse> {

    private final IAgencyService agencyService;

    public FindAgencyByIdQueryHandler(IAgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    public FindAgencyByIdResponse handle(FindAgencyByIdQuery query) {

        AgencyId id = new AgencyId(query.getId());
        Agency agency = agencyService.findById(id);

        return new FindAgencyByIdResponse(agency);
    }

}
