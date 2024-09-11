package cloud.tteams.identity.profile.infrastructure.adapter.query;

import java.util.UUID;

import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IProfileQueryJPARepository extends JpaRepository<ProfileEntity, UUID>, JpaSpecificationExecutor<ProfileEntity> {

}
