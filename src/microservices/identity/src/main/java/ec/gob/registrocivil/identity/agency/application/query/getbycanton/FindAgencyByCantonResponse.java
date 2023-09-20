package ec.gob.registrocivil.identity.agency.application.query.getbycanton;

import java.util.List;

import ec.gob.registrocivil.identity.agency.application.query.AgencyResponse;
import ec.gob.registrocivil.share.core.domain.bus.query.IResponse;

public class FindAgencyByCantonResponse implements IResponse {

    private List<AgencyResponse> agencies;

    public FindAgencyByCantonResponse(List<AgencyResponse> agencies) {
        this.agencies = agencies;
    }

    public List<AgencyResponse> getAgencies() {
        return agencies;
    }

}
