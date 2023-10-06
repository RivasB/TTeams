package cloud.tteams.station.station.infrastructure.adapter.query;


import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationStatus;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;
import java.util.UUID;
import org.springframework.data.jpa.domain.Specification;

public interface ISpringStationReadDataJPARepository extends JpaRepository<StationDto, UUID> {

    Set<StationDto> findByChargerTypeAndStatus(StationChargerType vehicleChargerType, StationStatus stationStatus);
}
