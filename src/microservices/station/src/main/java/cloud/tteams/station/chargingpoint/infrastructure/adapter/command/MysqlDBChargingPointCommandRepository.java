package cloud.tteams.station.chargingpoint.infrastructure.adapter.command;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointCommandRepository;
import cloud.tteams.station.chargingpoint.infrastructure.adapter.query.ISpringChargingPointReadDataJPARepository;
import cloud.tteams.station.chargingpoint.infrastructure.exception.ChargingPointNotFound;
import cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import cloud.tteams.station.station.infrastructure.adapter.query.ISpringStationReadDataJPARepository;
import cloud.tteams.station.station.infrastructure.exception.StationNotFoundException;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlDBChargingPointCommandRepository implements IChargingPointCommandRepository {

    private final ISpringChargingPointWriteDataJPARepository jpaRepository;

    private final ISpringChargingPointReadDataJPARepository chargingPointReadDataJPARepository;

    private final ISpringStationReadDataJPARepository readDataJPARepository;

    public MysqlDBChargingPointCommandRepository(ISpringChargingPointWriteDataJPARepository jpaRepository, ISpringChargingPointReadDataJPARepository chargingPointReadDataJPARepository, ISpringStationReadDataJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
        this.chargingPointReadDataJPARepository = chargingPointReadDataJPARepository;
        this.readDataJPARepository = readDataJPARepository;
    }

    @Override
    public void create(ChargingPoint chargingPoint) {
        StationDto stationDto =
                readDataJPARepository.findById(chargingPoint.getStation().getId().getValue())
                        .orElseThrow(StationNotFoundException::new);
        ChargingPointDto toPersist = new ChargingPointDto(chargingPoint.getId().getValue(),
                chargingPoint.getPowerLevel().getValue(),stationDto);
        jpaRepository.save(toPersist);
    }

    @Override
    public void update(ChargingPoint chargingPoint) {
        jpaRepository.save(new ChargingPointDto(chargingPoint));
    }

    @Override
    public void delete(ChargingPointId chargingPointId) {
        ChargingPointDto toDelete = chargingPointReadDataJPARepository.findById(chargingPointId.getValue())
                        .orElseThrow(ChargingPointNotFound::new);
        jpaRepository.delete(toDelete);
    }
}
