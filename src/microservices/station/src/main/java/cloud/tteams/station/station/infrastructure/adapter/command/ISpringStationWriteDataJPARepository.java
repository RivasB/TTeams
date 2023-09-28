package cloud.tteams.station.station.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringStationWriteDataJPARepository extends JpaRepository<AccessDto, UUID> {

}
