package cloud.tteams.station.location.infrastructure.adapter.command;

import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.domain.repository.ILocationCommandRepository;
import cloud.tteams.station.location.infrastructure.repository.hibernate.LocationDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MysqlDBLocationCommandRepository implements ILocationCommandRepository {

    private final ISpringLocationWriteDataJPARepository jpaRepository;

    public MysqlDBLocationCommandRepository(ISpringLocationWriteDataJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void create(Location location) {
        jpaRepository.save(new LocationDto(location));
    }

    @Override
    public void update(Location location) {
        jpaRepository.save(new LocationDto(location));
    }

    @Override
    public void delete(Location location) {
        jpaRepository.delete(new LocationDto(location));
    }
}
