package cloud.tteams.identity.user.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringUserWriteDataJPARepository extends JpaRepository<UserDto, UUID> {

}
