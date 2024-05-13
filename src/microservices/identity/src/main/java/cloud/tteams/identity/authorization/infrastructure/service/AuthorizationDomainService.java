package cloud.tteams.identity.authorization.infrastructure.service;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.identity.authorization.domain.repository.IAuthorizationCommandRepository;
import cloud.tteams.identity.authorization.domain.repository.IAuthorizationQueryRepository;
import cloud.tteams.identity.authorization.domain.service.IAuthorizationService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthorizationDomainService implements IAuthorizationService {

    private final IAuthorizationQueryRepository queryRepository;
    private final IAuthorizationCommandRepository commandRepository;

    public AuthorizationDomainService(IAuthorizationQueryRepository queryRepository, IAuthorizationCommandRepository commandRepository) {
        this.queryRepository = queryRepository;
        this.commandRepository = commandRepository;
    }

    @Override
    public void create(Authorization authorization) {
        commandRepository.create(authorization);
    }

    @Override
    public void update(Authorization authorization) {
        Authorization toUpdate = this.findById(authorization.getId());
        toUpdate.update(authorization);
        commandRepository.update(toUpdate);
    }

    @Override
    public void delete(UUID id) {
        Authorization toDelete = this.findById(id);
        commandRepository.delete(toDelete);
    }

    @Override
    public Authorization findById(UUID id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse getAll(Pageable pageable, String name, String resource, AuthorizedAction action, State state) {
        return queryRepository.findAll(pageable, name, resource, action, state);
    }
}
