package cloud.tteams.identity.authorization.infrastructure.adapter.command;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cloud.tteams.identity.authorization.domain.repository.IAuthorizationCommandRepository;

@Component
@Primary
public class AuthorizationCommandRepositoryImplementation implements IAuthorizationCommandRepository {

    private final IAuthorizationCommandJPARepository repository;

    public AuthorizationCommandRepositoryImplementation(final IAuthorizationCommandJPARepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Authorization authorization) {
        repository.save(new AuthorizationEntity(authorization));
    }

    @Override
    public void update(Authorization authorization) {
        repository.save(new AuthorizationEntity(authorization));
    }

    @Override
    public void delete(Authorization authorization) {
        repository.delete(new AuthorizationEntity(authorization));
    }
}
