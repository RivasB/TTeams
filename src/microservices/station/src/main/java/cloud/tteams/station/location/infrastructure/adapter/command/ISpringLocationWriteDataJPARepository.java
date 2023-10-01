package cloud.tteams.station.location.infrastructure.adapter.command;

import cloud.tteams.station.location.infrastructure.repository.hibernate.LocationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ISpringLocationWriteDataJPARepository extends JpaRepository<LocationDto, UUID> {
}
