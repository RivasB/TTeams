package ec.gob.registrocivil.identity.validation_mesh.infrastructure.adapter.query;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.profile.infrastructure.exception.ProfileNotFoundException;
import ec.gob.registrocivil.identity.validation_mesh.domain.Validation;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByService;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationByServiceId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationDescription;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationId;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;
import ec.gob.registrocivil.identity.validation_mesh.domain.repository.IValidationQueryRepository;
import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;
import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;

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
