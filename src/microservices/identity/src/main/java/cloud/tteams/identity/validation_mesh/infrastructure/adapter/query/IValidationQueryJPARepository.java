package cloud.tteams.identity.validation_mesh.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IValidationQueryJPARepository extends JpaRepository<ValidationDto, UUID> {

    public Optional<ValidationDto> findByCedulaCondition(String description);
}
