package cloud.tteams.identity.authorization.domain.repository;

import cloud.tteams.identity.authorization.domain.Authorization;
import cloud.tteams.identity.authorization.domain.AuthorizedAction;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IAuthorizationQueryRepository {

    Authorization findById(UUID id);
    
    MessagePaginatedResponse findAll(Pageable pageable, String name, String resource, AuthorizedAction authorizedAction, State state);

}
