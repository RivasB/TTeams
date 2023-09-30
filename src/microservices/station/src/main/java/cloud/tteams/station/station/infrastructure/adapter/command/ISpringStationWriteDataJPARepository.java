package cloud.tteams.station.station.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISpringStationWriteDataJPARepository extends JpaRepository<StationDto, UUID> {

}
