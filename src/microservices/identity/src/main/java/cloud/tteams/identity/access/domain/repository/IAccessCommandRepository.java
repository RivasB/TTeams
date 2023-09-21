package cloud.tteams.identity.access.domain.repository;

import cloud.tteams.identity.access.domain.Access;

public interface IAccessCommandRepository {

    void create(Access access);

    void update(Access access);

    void delete(Access access);
}
