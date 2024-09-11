package cloud.tteams.identity.user.infrastructure.adapter.command.user;

import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringUserWriteDataJPARepository extends JpaRepository<UserEntity, UUID> {

}
