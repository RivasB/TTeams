package cloud.tteams.station.station.infrastructure.adapter.command;

import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.repository.IStationCommandRepository;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlDBStationCommandRepository implements IStationCommandRepository {

    private final ISpringStationWriteDataJPARepository jpaRepository;

    public MysqlDBStationCommandRepository(final ISpringStationWriteDataJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
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
    public void delete(Station station) {
        jpaRepository.delete(new StationDto(station));
    }
}
