package cloud.tteams.station.chargingpoint.infrastructure.adapter.command;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.repository.IChargingPointCommandRepository;
import cloud.tteams.station.chargingpoint.infrastructure.adapter.query.ISpringChargingPointReadDataJPARepository;
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

    private final ISpringStationReadDataJPARepository readDataJPARepository;

    public MysqlDBChargingPointCommandRepository(ISpringChargingPointWriteDataJPARepository jpaRepository, ISpringStationReadDataJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
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
    public void delete(ChargingPoint chargingPoint) {
        jpaRepository.delete(new ChargingPointDto(chargingPoint));
    }
}
