package ec.gob.registrocivil.identity.access.infrastructure.adapter.command;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ec.gob.registrocivil.identity.access.domain.Access;
import ec.gob.registrocivil.identity.access.domain.repository.IAccessCommandRepository;
import ec.gob.registrocivil.identity.access.infrastructure.repository.hibernate.AccessDto;

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
