package cloud.tteams.station.station.infrastructure.adapter.command;

import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.access.domain.Station;
import cloud.tteams.identity.access.domain.repository.IStationCommandRepository;

@Component
@Primary
public class MysqlDBStationCommandRepository implements IStationCommandRepository {

    private final ISpringAccessWriteDataJPARepository accessRespository;

    public MysqlDBStationCommandRepository(final ISpringAccessWriteDataJPARepository accessRespository) {
        this.accessRespository = accessRespository;
    }

    @Override
    public void create(Station access) {
        accessRespository.save(new AccessDto(access));
    }

    @Override
    public void update(Station access) {
        accessRespository.save(new AccessDto(access));
    }

    @Override
    public void delete(Station access) {
        accessRespository.delete(new AccessDto(access));
    }
}