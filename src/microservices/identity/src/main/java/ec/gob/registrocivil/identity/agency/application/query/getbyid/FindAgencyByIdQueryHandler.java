package ec.gob.registrocivil.identity.agency.application.query.getbyid;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
