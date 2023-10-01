package cloud.tteams.station.chargingpoint.infrastructure.adapter.command;

import cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ISpringChargingPointWriteDataJPARepository extends JpaRepository<ChargingPointDto, UUID> {
}
