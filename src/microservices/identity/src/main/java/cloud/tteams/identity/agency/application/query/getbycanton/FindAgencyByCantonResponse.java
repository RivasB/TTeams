package cloud.tteams.identity.agency.application.query.getbycanton;

import java.util.List;

import cloud.tteams.identity.agency.application.query.AgencyResponse;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindAgencyByCantonResponse implements IResponse {

    private List<AgencyResponse> agencies;

    public FindAgencyByCantonResponse(List<AgencyResponse> agencies) {
        this.agencies = agencies;
    }

    public List<AgencyResponse> getAgencies() {
        return agencies;
    }

}
