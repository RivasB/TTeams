package cloud.tteams.identity.authorization.domain.repository;

import cloud.tteams.identity.authorization.domain.Authorization;

public interface IAuthorizationCommandRepository {

    void create(Authorization authorization);

    void update(Authorization authorization);

    void delete(Authorization authorization);
}
