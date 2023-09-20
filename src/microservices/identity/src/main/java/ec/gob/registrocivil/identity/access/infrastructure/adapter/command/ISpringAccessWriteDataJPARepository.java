package ec.gob.registrocivil.identity.access.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.access.infrastructure.repository.hibernate.AccessDto;

public interface ISpringAccessWriteDataJPARepository extends JpaRepository<AccessDto, UUID> {

}
