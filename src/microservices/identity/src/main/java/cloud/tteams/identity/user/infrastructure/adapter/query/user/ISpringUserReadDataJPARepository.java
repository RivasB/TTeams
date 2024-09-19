package cloud.tteams.identity.user.infrastructure.adapter.query.user;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserEntity;
import cloud.tteams.share.core.infrastructure.config.annotation.QueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

@QueryRepository
public interface ISpringUserReadDataJPARepository extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    Long countByIdNotAndEmail(UUID id, String email);

    Long countByIdIsNotAndIdentification(UUID id, String identification);

    <T> Page<UserEntity> findAll(Specification<T> tSpecification, Pageable pageable);

    boolean existsByEmailAndIdNot(String email, UUID id);
}
