package cloud.tteams.identity.organization.application.query.getbycanton;

import java.util.UUID;

import cloud.tteams.share.core.domain.bus.query.IQuery;

public class FindAgencyByCantonQuery implements IQuery {

    private UUID canton;

    public FindAgencyByCantonQuery(UUID canton) {
        this.canton = canton;
    }

    public UUID getCanton() {
        return canton;
    }

}
