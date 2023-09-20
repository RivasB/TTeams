package ec.gob.registrocivil.identity.agency.application.query.getbycanton;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.application.query.AgencyResponse;
import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

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
