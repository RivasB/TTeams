package cloud.tteams.identity.agency.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.agency.infrastructure.repository.hibernate.AgencyDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringAgencyWriteDataJPARepository extends JpaRepository<AgencyDto, UUID> {

}
