package cloud.tteams.identity.organization.infrastructure.adapter.query;

import java.util.UUID;

import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import cloud.tteams.share.core.infrastructure.config.annotation.QueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

@QueryRepository
public interface IOrganizationQueryJPARepository extends JpaRepository<OrganizationEntity, UUID> {
    <T> Page<OrganizationEntity> findAll(Specification<T> tSpecification, Pageable pageable);
}
