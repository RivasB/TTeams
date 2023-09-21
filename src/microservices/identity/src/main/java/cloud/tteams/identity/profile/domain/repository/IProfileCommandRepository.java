package cloud.tteams.identity.profile.domain.repository;

import cloud.tteams.identity.profile.domain.Profile;

public interface IProfileCommandRepository {
    void create(Profile profile);

    void update(Profile profile);

    void delete(Profile profile);
}
