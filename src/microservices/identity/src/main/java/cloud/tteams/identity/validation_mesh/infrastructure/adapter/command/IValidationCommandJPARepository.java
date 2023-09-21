package cloud.tteams.identity.validation_mesh.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IValidationCommandJPARepository extends JpaRepository<ValidationDto, UUID> {

}
