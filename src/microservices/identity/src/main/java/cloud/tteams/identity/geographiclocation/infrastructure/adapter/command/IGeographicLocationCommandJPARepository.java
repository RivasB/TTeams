package cloud.tteams.identity.geographiclocation.infrastructure.adapter.command;

import java.util.UUID;

import cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGeographicLocationCommandJPARepository extends JpaRepository<GeographicLocationDto, UUID> {

}
