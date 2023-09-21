package cloud.tteams.identity.validation_mesh.domain.repository;

import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationByServiceId;
import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationDescription;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;

public interface IValidationQueryRepository {

    public Validation findValidationById(ValidationId id);

    public Validation findValidationWithConditions(ValidationDescription description);

    public ValidationByService findValidationByServiceById(ValidationByServiceId id);

    public ValidationByService findValidationByServiceWithConditions(ValidationId validationId,
            ValidationServiceType type, ValidationCivilStatus status);
}
