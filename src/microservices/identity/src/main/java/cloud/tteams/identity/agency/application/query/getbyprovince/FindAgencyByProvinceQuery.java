package cloud.tteams.identity.agency.application.query.getbyprovince;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindAgencyByProvinceQuery implements IQuery {

    private UUID province;

    public FindAgencyByProvinceQuery(UUID province) {
        this.province = province;
    }

    public UUID getProvince() {
        return province;
    }

}
