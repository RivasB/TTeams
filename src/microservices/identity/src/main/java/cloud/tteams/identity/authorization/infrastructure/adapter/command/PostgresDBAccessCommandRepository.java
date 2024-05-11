package cloud.tteams.identity.authorization.infrastructure.adapter.command;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AccessDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.authorization.domain.Access;
import cloud.tteams.identity.authorization.domain.repository.IAccessCommandRepository;

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
