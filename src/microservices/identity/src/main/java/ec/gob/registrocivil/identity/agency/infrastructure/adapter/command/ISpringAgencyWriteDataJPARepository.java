package ec.gob.registrocivil.identity.agency.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.agency.infrastructure.repository.hibernate.AgencyDto;

public interface ISpringAgencyWriteDataJPARepository extends JpaRepository<AgencyDto, UUID> {

}
