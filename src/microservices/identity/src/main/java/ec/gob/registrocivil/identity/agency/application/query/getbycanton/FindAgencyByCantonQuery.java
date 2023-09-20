package ec.gob.registrocivil.identity.agency.application.query.getbycanton;

import java.util.UUID;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindAgencyByCantonQuery implements IQuery {

    private UUID canton;

    public FindAgencyByCantonQuery(UUID canton) {
        this.canton = canton;
    }

    public UUID getCanton() {
        return canton;
    }

}
