package cloud.tteams.identity.organization.domain.repository;

import java.util.List;

import cloud.tteams.identity.organization.domain.Agency;

public interface IAgencyCommandRepository {
    public void create(Agency agency);

    public void update(Agency agency);

    public void delete(Agency agency);

    public List<Agency> findAll();

}
