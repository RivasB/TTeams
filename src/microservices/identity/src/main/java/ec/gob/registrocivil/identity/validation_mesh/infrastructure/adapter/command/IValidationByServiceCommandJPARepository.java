package ec.gob.registrocivil.identity.validation_mesh.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.validation_mesh.infrastructure.repository.hibernate.ValidationByServiceDto;

public interface IValidationByServiceCommandJPARepository extends JpaRepository<ValidationByServiceDto, UUID> {

}
