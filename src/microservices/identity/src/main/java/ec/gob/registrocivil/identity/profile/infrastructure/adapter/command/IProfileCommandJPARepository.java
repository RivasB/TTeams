package ec.gob.registrocivil.identity.profile.infrastructure.adapter.command;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate.ProfileDto;

public interface IProfileCommandJPARepository extends JpaRepository<ProfileDto, UUID> {

}
