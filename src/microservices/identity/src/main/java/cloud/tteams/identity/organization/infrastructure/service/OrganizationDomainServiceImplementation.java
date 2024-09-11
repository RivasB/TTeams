package cloud.tteams.identity.organization.infrastructure.service;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.repository.IOrganizationCommandRepository;
import cloud.tteams.identity.organization.domain.repository.IOrganizationQueryRepository;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.service.IEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationDomainServiceImplementation implements IOrganizationService {
    private final IOrganizationCommandRepository commandRepository;
    private final IOrganizationQueryRepository queryRepository;
    private final IEventService<Organization> eventService;

    @Value("${kafka.messenger.organization:false}")
    private boolean messengerIsActive;

    public OrganizationDomainServiceImplementation(IOrganizationCommandRepository commandRepository, IOrganizationQueryRepository queryRepository,
                                                   IEventService<Organization> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void create(Organization organization) {
        commandRepository.create(organization);
        if (messengerIsActive) {
            eventService.create(organization);
        }
    }

    @Override
    public void update(Organization organization) {
        Organization toUpdate = queryRepository.findById(organization.getId());
        toUpdate.update(organization);
        commandRepository.update(toUpdate);
        if (messengerIsActive) {
            eventService.update(toUpdate);
        }
    }

    @Override
    public void delete(UUID id) {
        Organization organizationDelete = queryRepository.findById(id);
            commandRepository.delete(organizationDelete);
            if (messengerIsActive) {
                eventService.delete(organizationDelete);
            }
    }

    @Override
    public Organization findById(UUID id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse getAll(Pageable pageable, String name, String description, String contact,
                                           State state) {
        return queryRepository.findAll(pageable, name, description, contact, state);
    }

    @Override
    public void spreadOrganizations() {
        List<Organization> allOrganization = commandRepository.findAll();
        allOrganization.forEach(eventService::create);
    }

}
