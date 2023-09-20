package ec.gob.registrocivil.identity.aplication.infrastructure.adapter.command;

import ec.gob.registrocivil.identity.aplication.infrastructure.repository.hibernate.AplicationDto;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringAplicationWriteDataJPARepository extends JpaRepository<AplicationDto, UUID> {

}
