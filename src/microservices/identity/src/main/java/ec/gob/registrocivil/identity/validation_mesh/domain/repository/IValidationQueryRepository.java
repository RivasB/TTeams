package ec.gob.registrocivil.identity.validation_mesh.domain.repository;

import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;

public interface IValidationQueryRepository {

    public Validation findValidationById(ValidationId id);

    public Validation findValidationWithConditions(ValidationDescription description);

    public ValidationByService findValidationByServiceById(ValidationByServiceId id);

    public ValidationByService findValidationByServiceWithConditions(ValidationId validationId,
            ValidationServiceType type, ValidationCivilStatus status);
}
