package cloud.tteams.identity.validation_mesh.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IValidationByServiceCommandJPARepository extends JpaRepository<ValidationByServiceDto, UUID> {

}
