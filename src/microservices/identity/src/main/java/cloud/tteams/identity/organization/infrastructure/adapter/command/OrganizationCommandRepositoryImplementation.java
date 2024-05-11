package cloud.tteams.identity.organization.infrastructure.adapter.command;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.repository.IOrganizationCommandRepository;
import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
public class OrganizationCommandRepositoryImplementation implements IOrganizationCommandRepository {

    private final IOrganizationCommandJPARepository agencyRepository;

    public OrganizationCommandRepositoryImplementation(final IOrganizationCommandJPARepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    @Override
    public void create(Organization organization) {
        agencyRepository.save(new OrganizationEntity(organization));
    }

    @Override
    public void update(Organization organization) {
        agencyRepository.save(new OrganizationEntity(organization));
    }

    @Override
    public void delete(Organization organization) {
        agencyRepository.delete(new OrganizationEntity(organization));
    }

    @Override
    public List<Organization> findAll() {
        return agencyRepository.findAll().stream().map(OrganizationEntity::toAggregate).toList();
    }
}
