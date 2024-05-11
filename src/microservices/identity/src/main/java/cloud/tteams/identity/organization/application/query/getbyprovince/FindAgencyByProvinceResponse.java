package cloud.tteams.identity.organization.application.query.getbyprovince;

import java.util.List;

import cloud.tteams.identity.organization.application.query.AgencyResponse;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindAgencyByProvinceResponse implements IResponse {

    private List<AgencyResponse> agencies;

    public FindAgencyByProvinceResponse(List<AgencyResponse> agencies) {
        this.agencies = agencies;
    }

    public List<AgencyResponse> getAgencies() {
        return agencies;
    }

}
