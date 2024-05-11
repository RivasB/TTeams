package cloud.tteams.identity.authorization.domain.repository;

import cloud.tteams.identity.authorization.domain.Access;

public interface IAccessCommandRepository {

    void create(Access access);

    void update(Access access);

    void delete(Access access);
}
