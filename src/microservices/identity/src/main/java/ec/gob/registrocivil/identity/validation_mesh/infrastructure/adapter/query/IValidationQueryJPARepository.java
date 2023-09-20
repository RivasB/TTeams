package ec.gob.registrocivil.identity.validation_mesh.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;

public interface IValidationQueryJPARepository extends JpaRepository<ValidationDto, UUID> {

    public Optional<ValidationDto> findByCedulaCondition(String description);
}
