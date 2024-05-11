package cloud.tteams.identity.organization.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganizationCommandJPARepository extends JpaRepository<OrganizationEntity, UUID> {

}
