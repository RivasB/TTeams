package ec.gob.registrocivil.identity.profile.domain.repository;

import ec.gob.registrocivil.identity.profile.domain.Profile;

public interface IProfileCommandRepository {
    void create(Profile profile);

    void update(Profile profile);

    void delete(Profile profile);
}
