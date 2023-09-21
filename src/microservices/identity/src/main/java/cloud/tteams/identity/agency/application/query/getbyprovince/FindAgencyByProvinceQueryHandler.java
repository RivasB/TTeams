package cloud.tteams.identity.agency.application.query.getbyprovince;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import cloud.tteams.identity.agency.application.query.AgencyResponse;
import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.identity.agency.domain.service.IAgencyService;
import cloud.tteams.identity.geographiclocation.domain.GeographicLocationId;
import cloud.tteams.share.core.domain.bus.query.IQueryHandler;

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
