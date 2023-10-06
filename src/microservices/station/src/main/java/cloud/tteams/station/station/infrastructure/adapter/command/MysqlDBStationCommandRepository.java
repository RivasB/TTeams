package cloud.tteams.station.station.infrastructure.adapter.command;

import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.repository.IStationCommandRepository;
import cloud.tteams.station.station.infrastructure.adapter.query.ISpringStationReadDataJPARepository;
import cloud.tteams.station.station.infrastructure.exception.StationNotFoundException;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlDBStationCommandRepository implements IStationCommandRepository {

    private final ISpringStationWriteDataJPARepository jpaRepository;

    private final ISpringStationReadDataJPARepository readDataJPARepository;

    public MysqlDBStationCommandRepository(final ISpringStationWriteDataJPARepository jpaRepository, ISpringStationReadDataJPARepository readDataJPARepository) {
        this.jpaRepository = jpaRepository;
        this.readDataJPARepository = readDataJPARepository;
    }

    @Override
    public void create(Station station) {
        jpaRepository.save(new StationDto(station));
    }

    @Override
    public void update(Station station) {
        jpaRepository.save(new StationDto(station));
    }

    @Override
    public void delete(StationId stationId) {
        StationDto toDelete =
                readDataJPARepository.findById(stationId.getValue()).orElseThrow(StationNotFoundException::new);
        jpaRepository.delete(toDelete);
    }
}
