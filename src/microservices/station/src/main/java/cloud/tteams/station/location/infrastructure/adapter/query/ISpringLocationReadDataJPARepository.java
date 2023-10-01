package cloud.tteams.station.location.infrastructure.adapter.query;

import cloud.tteams.station.location.infrastructure.repository.hibernate.LocationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ISpringLocationReadDataJPARepository extends JpaRepository<LocationDto, UUID> {
}
