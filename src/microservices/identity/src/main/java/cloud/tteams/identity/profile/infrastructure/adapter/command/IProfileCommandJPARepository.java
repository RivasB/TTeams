package cloud.tteams.identity.profile.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfileCommandJPARepository extends JpaRepository<ProfileEntity, UUID> {

}
