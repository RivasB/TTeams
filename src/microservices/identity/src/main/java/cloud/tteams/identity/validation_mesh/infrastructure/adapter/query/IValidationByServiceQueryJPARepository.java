package cloud.tteams.identity.validation_mesh.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.tteams.identity.validation_mesh.domain.ValidationCivilStatus;
import cloud.tteams.identity.validation_mesh.domain.ValidationServiceType;

public interface IValidationByServiceQueryJPARepository extends JpaRepository<ValidationByServiceDto, UUID> {

    Optional<ValidationByServiceDto> findByValidationIdAndTypeAndStatus(UUID value,
            ValidationServiceType type, ValidationCivilStatus status);

}
