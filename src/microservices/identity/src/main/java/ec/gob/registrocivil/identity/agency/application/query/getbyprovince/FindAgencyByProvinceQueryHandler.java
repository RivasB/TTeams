package ec.gob.registrocivil.identity.agency.application.query.getbyprovince;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.agency.application.query.AgencyResponse;
import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.service.IAgencyService;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.share.core.domain.bus.query.IQueryHandler;

@Component
public class FindAgencyByProvinceQueryHandler
        implements IQueryHandler<FindAgencyByProvinceQuery, FindAgencyByProvinceResponse> {

    private final IAgencyService agencyService;

    public FindAgencyByProvinceQueryHandler(IAgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @Override
    public FindAgencyByProvinceResponse handle(FindAgencyByProvinceQuery query) {

        GeographicLocationId province = new GeographicLocationId(query.getProvince());
        List<Agency> agencies = agencyService.findByProvince(province);

        List<AgencyResponse> response = agencies.stream().map(AgencyResponse::new).collect(Collectors.toList());

        return new FindAgencyByProvinceResponse(response);
    }

}
