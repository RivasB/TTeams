package cloud.tteams.identity.access.infrastructure.adapter.command;

import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.domain.repository.IAccessCommandRepository;

@Component
@Primary
public class PostgresDBAccessCommandRepository implements IAccessCommandRepository {

    private final ISpringAccessWriteDataJPARepository accessRespository;

    public PostgresDBAccessCommandRepository(final ISpringAccessWriteDataJPARepository accessRespository) {
        this.accessRespository = accessRespository;
    }

    @Override
    public void create(Access access) {
        accessRespository.save(new AccessDto(access));
    }

    @Override
    public void update(Access access) {
        accessRespository.save(new AccessDto(access));
    }

    @Override
    public void delete(Access access) {
        accessRespository.delete(new AccessDto(access));
    }
}
