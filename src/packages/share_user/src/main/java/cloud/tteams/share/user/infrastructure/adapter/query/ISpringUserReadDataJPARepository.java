package cloud.tteams.share.user.infrastructure.adapter.query;


import cloud.tteams.share.user.infrastructure.repository.hibernate.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ISpringUserReadDataJPARepository extends JpaRepository<UserDto, UUID> {

    Optional<UserDto> findByIdentification(String identification);
}
