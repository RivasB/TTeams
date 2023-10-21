package cloud.tteams.share.user.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.share.user.infrastructure.repository.hibernate.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringUserWriteDataJPARepository extends JpaRepository<UserDto, UUID> {

}
