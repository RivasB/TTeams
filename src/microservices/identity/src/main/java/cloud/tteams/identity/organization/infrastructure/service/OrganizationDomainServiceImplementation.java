package cloud.tteams.identity.organization.infrastructure.service;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.organization.domain.repository.IOrganizationCommandRepository;
import cloud.tteams.identity.organization.domain.repository.IOrganizationQueryRepository;
import cloud.tteams.identity.organization.domain.service.IOrganizationService;
import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.share.core.domain.service.ILogService;
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
    private final ILogService logService;

    @Value("${kafka.messenger.notifications:true}")
    private boolean messengerIsActive;

    public OrganizationDomainServiceImplementation(IOrganizationCommandRepository commandRepository, IOrganizationQueryRepository queryRepository,
                                                   IEventService<Organization> eventService, ILogService logService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
        this.logService = logService;
    }

    @Override
    public void create(Organization organization) {
        commandRepository.create(organization);
        String username = UserContext.getUserSession() != null ? UserContext.getUserSession().getUsername() : "system/unknown";
        logService.info(String.format("New Organization created with: Id: %s and Name: %s  by the user: %s",
                organization.getId(),
                organization.getName(), username), organization);
        publish(EventType.CREATED, organization);
    }

    @Override
    public void update(Organization organization) {
        Organization toUpdate = queryRepository.findById(organization.getId());
        toUpdate.update(organization);
        commandRepository.update(toUpdate);
        String username = UserContext.getUserSession() != null ? UserContext.getUserSession().getUsername() : "system/unknown";
        logService.info(String.format("New Organization updated with: Id: %s and Name: %s  by the user: %s",
                toUpdate.getId(),
                toUpdate.getName(), username), toUpdate);
        publish(EventType.UPDATED, toUpdate);
    }

    @Override
    public void delete(UUID id) {
        Organization organizationDelete = queryRepository.findById(id);
        commandRepository.delete(organizationDelete);
        String username = UserContext.getUserSession() != null ? UserContext.getUserSession().getUsername() : "system/unknown";
        logService.info(String.format("New Organization deleted with: Id: %s and Name: %s  by the user: %s",
                organizationDelete.getId(),
                organizationDelete.getName(), username), organizationDelete);
        publish(EventType.DELETED, organizationDelete);
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

    private void publish(EventType eventType, Organization organization) {
        if (messengerIsActive) {
            eventService.publish(eventType, organization);
        }
    }

}
