package cloud.tteams.identity.aplication.domain.repository;

import cloud.tteams.identity.aplication.domain.Aplication;

public interface IAplicationCommandRepository {
    public void create(Aplication aplication);

    public void update(Aplication aplication);

    public void delete(Aplication aplication);

}
