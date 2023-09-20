package ec.gob.registrocivil.identity.validation_mesh.application.query.find;

import ec.gob.registrocivil.share.core.domain.bus.query.IQuery;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;

public class FindValidationByServiceActQuery implements IQuery {

    private String cedulaCondition;

    private ValidationServiceType type;

    private ValidationCivilStatus status;

    public FindValidationByServiceActQuery(String cedulaCondition, ValidationServiceType type,
            ValidationCivilStatus status) {
        this.cedulaCondition = cedulaCondition;
        this.type = type;
        this.status = status;
    }

    public String getCedulaCondition() {
        return cedulaCondition;
    }

    public ValidationServiceType getType() {
        return type;
    }

    public ValidationCivilStatus getStatus() {
        return status;
    }

}
