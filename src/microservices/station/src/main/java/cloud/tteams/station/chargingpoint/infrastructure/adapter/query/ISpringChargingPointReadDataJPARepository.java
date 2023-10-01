package cloud.tteams.station.chargingpoint.infrastructure.adapter.query;

import cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ISpringChargingPointReadDataJPARepository extends JpaRepository<ChargingPointDto, UUID> {
}
