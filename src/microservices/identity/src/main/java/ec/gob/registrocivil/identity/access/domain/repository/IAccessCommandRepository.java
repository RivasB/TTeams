package ec.gob.registrocivil.identity.access.domain.repository;

import ec.gob.registrocivil.identity.access.domain.Access;

public interface IAccessCommandRepository {

    void create(Access access);

    void update(Access access);

    void delete(Access access);
}
