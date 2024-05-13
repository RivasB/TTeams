package cloud.tteams.identity.authorization.domain.service;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IAuthorizationService {

    void create(Authorization authorization);

    void update(Authorization authorization);

    void delete(UUID id);

    Authorization findById(UUID id);

    MessagePaginatedResponse getAll(Pageable pageable, String name, String resource, AuthorizedAction action, State state);

}
