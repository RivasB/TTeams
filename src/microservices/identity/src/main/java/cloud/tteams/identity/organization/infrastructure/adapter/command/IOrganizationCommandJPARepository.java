package cloud.tteams.identity.organization.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import org.springframework.data.jpa.repository.JpaRepository;

@CommandRepository
public interface IOrganizationCommandJPARepository extends JpaRepository<OrganizationEntity, UUID> {

}
