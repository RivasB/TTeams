package cloud.tteams.identity.validation_mesh.domain.repository;

import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationByServiceId;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;

public interface IValidationCommandRepository {

    public void createValidation(Validation validation);

    public void updateValidation(Validation validation);

    public void deleteValidation(ValidationId id);

    public void createValidationByService(ValidationByService validation);

    public void updateValidationByService(ValidationByService validation);

    public void deleteValidationByService(ValidationByServiceId id);

}
