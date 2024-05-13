package cloud.tteams.identity.authorization.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@CommandRepository
public interface IAuthorizationCommandJPARepository extends JpaRepository<AuthorizationEntity, UUID> {

}
