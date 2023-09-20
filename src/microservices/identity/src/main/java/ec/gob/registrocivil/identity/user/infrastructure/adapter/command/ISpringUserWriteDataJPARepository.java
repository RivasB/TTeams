package ec.gob.registrocivil.identity.user.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.UserDto;

public interface ISpringUserWriteDataJPARepository extends JpaRepository<UserDto, UUID> {

}
