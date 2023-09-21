package cloud.tteams.identity.validation_mesh.infrastructure.adapter.query;

import java.util.Optional;

import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;
import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.profile.infrastructure.exception.ProfileNotFoundException;
import cloud.tteams.identity.validation_mesh.domain.Validation;
import cloud.tteams.identity.validation_mesh.domain.ValidationByService;
import cloud.tteams.identity.validation_mesh.domain.ValidationByServiceId;
import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationDescription;
import cloud.tteams.identity.validation_mesh.domain.ValidationId;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;
import cloud.tteams.identity.validation_mesh.domain.repository.IValidationQueryRepository;

@Component
@Primary
public class PostgreDBValidationQueryRepository implements IValidationQueryRepository {

    private final IValidationQueryJPARepository validationQueryJPARepository;

    private final IValidationByServiceQueryJPARepository validationByServiceQueryJPARepository;

    public PostgreDBValidationQueryRepository(IValidationQueryJPARepository validationQueryJPARepository,
            IValidationByServiceQueryJPARepository validationByServiceQueryJPARepository) {

        this.validationQueryJPARepository = validationQueryJPARepository;
        this.validationByServiceQueryJPARepository = validationByServiceQueryJPARepository;
    }

    @Override
    public Validation findValidationById(ValidationId id) {
        Optional<ValidationDto> validationDto = validationQueryJPARepository.findById(id.value());

        if (!validationDto.isPresent()) {
            throw new ProfileNotFoundException("Validation not found");
        }
        return validationDto.get().toAggregate();
    }

    @Override
    public Validation findValidationWithConditions(ValidationDescription description) {
        Optional<ValidationDto> validationDto = validationQueryJPARepository.findByCedulaCondition(description.value());

        if (!validationDto.isPresent()) {
            throw new ProfileNotFoundException("Validation not found");
        }
        return validationDto.get().toAggregate();
    }

    @Override
    public ValidationByService findValidationByServiceById(ValidationByServiceId id) {
        Optional<ValidationByServiceDto> validationByServiceDto = validationByServiceQueryJPARepository
                .findById(id.value());

        if (!validationByServiceDto.isPresent()) {
            throw new ProfileNotFoundException("Validation By Service not found");
        }
        return validationByServiceDto.get().toAggregate();
    }

    @Override
    public ValidationByService findValidationByServiceWithConditions(ValidationId validationId,
            ValidationServiceType type, ValidationCivilStatus status) {

        Optional<ValidationByServiceDto> validationByServiceDto = validationByServiceQueryJPARepository
                .findByValidationIdAndTypeAndStatus(validationId.value(), type, status);

        if (!validationByServiceDto.isPresent()) {
            throw new ProfileNotFoundException("Validation By Service not found");
        }
        return validationByServiceDto.get().toAggregate();
    }

}
