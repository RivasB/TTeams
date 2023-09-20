package ec.gob.registrocivil.identity.validation_mesh.infrastructure.service;

import org.springframework.stereotype.Service;

import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;
import ec.gob.registrocivil.identity.validation_mesh.domain.repository.IValidationCommandRepository;
import ec.gob.registrocivil.identity.validation_mesh.domain.repository.IValidationQueryRepository;
import ec.gob.registrocivil.identity.validation_mesh.domain.service.IValidationService;

@Service
public class DomainValidationService implements IValidationService {

    private final IValidationCommandRepository validationCommandRepository;

    private final IValidationQueryRepository validationQueryRepository;

    public DomainValidationService(IValidationCommandRepository validationCommandRepository,
            IValidationQueryRepository validationQueryRepository) {

        this.validationCommandRepository = validationCommandRepository;
        this.validationQueryRepository = validationQueryRepository;
    }

    @Override
    public void createValidation(Validation validation) {
        validationCommandRepository.createValidation(validation);
    }

    @Override
    public void updateValidation(Validation validation) {
        validationCommandRepository.updateValidation(validation);
    }

    @Override
    public void deleteValidation(ValidationId id) {
        validationCommandRepository.deleteValidation(id);
    }

    @Override
    public Validation findValidationById(ValidationId id) {
        return validationQueryRepository.findValidationById(id);
    }

    @Override
    public Validation findValidationWithConditions(ValidationDescription description) {
        return validationQueryRepository.findValidationWithConditions(description);
    }

    @Override
    public void createValidationByService(ValidationByService validation) {
        validationCommandRepository.createValidationByService(validation);
    }

    @Override
    public void updateValidationByService(ValidationByService validation) {
        validationCommandRepository.updateValidationByService(validation);
    }

    @Override
    public void deleteValidationByService(ValidationByServiceId id) {
        validationCommandRepository.deleteValidationByService(id);
    }

    @Override
    public ValidationByService findValidationByServiceById(ValidationByServiceId id) {
        return validationQueryRepository.findValidationByServiceById(id);
    }

    @Override
    public ValidationByService findValidationByServiceWithConditions(ValidationId validationId,
            ValidationServiceType type, ValidationCivilStatus status) {
        return validationQueryRepository.findValidationByServiceWithConditions(validationId, type, status);
    }

}
