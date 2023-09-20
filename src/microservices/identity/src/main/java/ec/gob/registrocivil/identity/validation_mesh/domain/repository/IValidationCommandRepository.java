package ec.gob.registrocivil.identity.validation_mesh.domain.repository;

import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;

public interface IValidationCommandRepository {

    public void createValidation(Validation validation);

    public void updateValidation(Validation validation);

    public void deleteValidation(ValidationId id);

    public void createValidationByService(ValidationByService validation);

    public void updateValidationByService(ValidationByService validation);

    public void deleteValidationByService(ValidationByServiceId id);

}
