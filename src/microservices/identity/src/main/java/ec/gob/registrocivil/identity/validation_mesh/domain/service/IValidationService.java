package ec.gob.registrocivil.identity.validation_mesh.domain.service;

import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;

public interface IValidationService {

    public void createValidation(Validation validation);

    public void updateValidation(Validation validation);

    public void deleteValidation(ValidationId id);

    public Validation findValidationById(ValidationId id);

    public Validation findValidationWithConditions(ValidationDescription description);

    public void createValidationByService(ValidationByService validation);

    public void updateValidationByService(ValidationByService validation);

    public void deleteValidationByService(ValidationByServiceId id);

    public ValidationByService findValidationByServiceById(ValidationByServiceId id);

    public ValidationByService findValidationByServiceWithConditions(ValidationId validationId,
            ValidationServiceType type, ValidationCivilStatus status);
}
