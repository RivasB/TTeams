package cloud.tteams.identity.organization.application.query.getbycanton;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.organization.application.query.AgencyResponse;
import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.service.IAgencyService;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindAgencyByCantonQueryHandler
        implements IQueryHandler<FindAgencyByCantonQuery, FindAgencyByCantonResponse> {

    private final IAgencyService agencyService;

    public FindAgencyByCantonQueryHandler(IAgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    public FindAgencyByCantonResponse handle(FindAgencyByCantonQuery query) {

        GeographicLocationId canton = new GeographicLocationId(query.getCanton());
        List<Agency> agencies = agencyService.findByCanton(canton);

        List<AgencyResponse> response = agencies.stream().map(AgencyResponse::new).collect(Collectors.toList());

        return new FindAgencyByCantonResponse(response);
    }

}
