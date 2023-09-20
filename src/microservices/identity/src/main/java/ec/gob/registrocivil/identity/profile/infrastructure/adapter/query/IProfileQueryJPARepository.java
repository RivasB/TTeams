package ec.gob.registrocivil.identity.profile.infrastructure.adapter.query;

import java.util.UUID;

import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate.ProfileDto;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProfileQueryJPARepository extends JpaRepository<ProfileDto, UUID>, JpaSpecificationExecutor<ProfileDto> {

}
