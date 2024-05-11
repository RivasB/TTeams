package cloud.tteams.identity.application.domain.repository;

import cloud.tteams.identity.application.domain.Aplication;

public interface IAplicationCommandRepository {
    public void create(Aplication aplication);

    public void update(Aplication aplication);

    public void delete(Aplication aplication);

}
