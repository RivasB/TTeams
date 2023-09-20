package ec.gob.registrocivil.identity.validation_mesh.infrastructure.adapter.command;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.repository.IValidationCommandRepository;
import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;
import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;

@Component
@Primary
public class PostgreDBValidationCommandRepository implements IValidationCommandRepository {

    private final IValidationCommandJPARepository validationCommandJPARepository;

    private final IValidationByServiceCommandJPARepository validationByServiceCommandJPARepository;

    public PostgreDBValidationCommandRepository(IValidationCommandJPARepository validationCommandJPARepository,
            IValidationByServiceCommandJPARepository validationByServiceCommandJPARepository) {

        this.validationCommandJPARepository = validationCommandJPARepository;
        this.validationByServiceCommandJPARepository = validationByServiceCommandJPARepository;
    }

    @Override
    public void createValidation(Validation validation) {
        validationCommandJPARepository.save(new ValidationDto(validation));
    }

    @Override
    public void updateValidation(Validation validation) {
        validationCommandJPARepository.save(new ValidationDto(validation));
    }

    @Override
    public void deleteValidation(ValidationId id) {
        validationCommandJPARepository.deleteById(id.value());
    }

    @Override
    public void createValidationByService(ValidationByService validation) {
        validationByServiceCommandJPARepository.save(new ValidationByServiceDto(validation));
    }

    @Override
    public void updateValidationByService(ValidationByService validation) {
        validationByServiceCommandJPARepository.save(new ValidationByServiceDto(validation));
    }

    @Override
    public void deleteValidationByService(ValidationByServiceId id) {
        validationByServiceCommandJPARepository.deleteById(id.value());
    }

}
