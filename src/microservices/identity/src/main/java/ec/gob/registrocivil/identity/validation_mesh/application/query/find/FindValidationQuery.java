package ec.gob.registrocivil.identity.validation_mesh.application.query.find;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;

public class FindValidationQuery implements IQuery {

    private String cedulaCondition;

    public FindValidationQuery(String cedulaCondition) {
        this.cedulaCondition = cedulaCondition;
    }

    public FindValidationQuery(FindValidationRequest request) {
        this.cedulaCondition = request.getCedulaCondition();
    }

    public String getCedulaCondition() {
        return cedulaCondition;
    }

}
