package cloud.tteams.identity.authorization.infrastructure.adapter.query;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.CommandRepository;
import cloud.tteams.share.core.infrastructure.config.annotation.QueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;

@QueryRepository
public interface IAuthorizationQueryJPARepository extends JpaRepository<AuthorizationEntity, UUID> {

    Page<AuthorizationEntity> getAccessDtoByCodeContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            String code, String description, Pageable pageable);
    
    <T> Page<AuthorizationEntity> findAll(Specification<T> tSpecification, Pageable pageable);

    AuthorizationEntity findByCode(String code);

    Long countByIdIsNotAndCode(UUID id, String code);

}
