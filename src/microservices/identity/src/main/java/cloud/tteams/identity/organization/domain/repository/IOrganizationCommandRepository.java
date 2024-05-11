package cloud.tteams.identity.organization.domain.repository;

import java.util.List;

import cloud.tteams.identity.organization.domain.Organization;

public interface IOrganizationCommandRepository {
    void create(Organization organization);

    void update(Organization organization);

    void delete(Organization organization);

    List<Organization> findAll();
}
