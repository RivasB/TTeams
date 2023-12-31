package cloud.tteams.identity.user.infrastructure.adapter.query;

import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.tteams.identity.user.domain.User;
import cloud.tteams.identity.user.domain.UserId;

public interface ISpringUserReadDataJPARepository extends JpaRepository<UserDto, UUID> {

    Optional<UserDto> findByIdentification(String identification);

    Page<UserDto> findAll(Pageable pageable);

    public Optional<UserDto> findById(UserId id);

    public Long countByIdentification(String identification);

    public Long countByEmail(String email);

    public User findByEmail(String email);

    public Long countByIdIsNotAndEmail(UUID id, String email);

    public Long countByIdIsNotAndIdentification(UUID id, String identification);

    <T> Page<UserDto> findAll(Specification<T> tSpecification, Pageable pageable);
}
