package cloud.tteams.identity.authorization.infrastructure.adapter.command;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.authorization.domain.repository.IAuthorizationCommandRepository;

@Component
@Primary
public class AuthorizationCommandRepositoryImplementation implements IAuthorizationCommandRepository {

    private final IAuthorizationCommandJPARepository accessRespository;

    public AuthorizationCommandRepositoryImplementation(final IAuthorizationCommandJPARepository accessRespository) {
        this.accessRespository = accessRespository;
    }

    @Override
    public void create(Authorization authorization) {
        accessRespository.save(new AuthorizationEntity(authorization));
    }

    @Override
    public void update(Authorization authorization) {
        accessRespository.save(new AuthorizationEntity(authorization));
    }

    @Override
    public void delete(Authorization authorization) {
        accessRespository.delete(new AuthorizationEntity(authorization));
    }
}
