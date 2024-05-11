package cloud.tteams.identity.authorization.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AccessDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringAccessWriteDataJPARepository extends JpaRepository<AccessDto, UUID> {

}
