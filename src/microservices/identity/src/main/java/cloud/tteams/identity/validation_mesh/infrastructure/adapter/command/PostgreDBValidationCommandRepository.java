package cloud.tteams.identity.validation_mesh.infrastructure.adapter.command;

import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;
import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationByServiceId;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;
import cloud.tteams.identity.validation_mesh.domain.repository.IValidationCommandRepository;

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
