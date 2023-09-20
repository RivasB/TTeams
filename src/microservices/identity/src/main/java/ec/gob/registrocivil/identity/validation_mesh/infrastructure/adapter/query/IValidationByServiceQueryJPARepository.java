package ec.gob.registrocivil.identity.validation_mesh.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationCivilStatus;
import ec.gob.registrocivil.identity.validation_mesh.domain.ValidationServiceType;
import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;

public interface IValidationByServiceQueryJPARepository extends JpaRepository<ValidationByServiceDto, UUID> {

    Optional<ValidationByServiceDto> findByValidationIdAndTypeAndStatus(UUID value,
            ValidationServiceType type, ValidationCivilStatus status);

}
