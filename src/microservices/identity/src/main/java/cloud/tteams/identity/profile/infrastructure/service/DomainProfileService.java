package cloud.tteams.identity.profile.infrastructure.service;

import cloud.tteams.share.config.context.UserContext;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.share.core.domain.service.ILogService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.identity.profile.domain.repository.IProfileCommandRepository;
import cloud.tteams.identity.profile.domain.repository.IProfileQueryRepository;
import cloud.tteams.identity.profile.domain.rules.ProfileAuthorizationsRequiredRule;
import cloud.tteams.identity.profile.domain.rules.ProfileOrganizationRequiredRule;
import cloud.tteams.identity.profile.domain.rules.ProfileNameRequiredRule;
import cloud.tteams.identity.profile.domain.rules.ProfileStateRequiredRule;
import cloud.tteams.identity.profile.domain.service.IProfileService;
import cloud.tteams.share.core.application.query.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.rules.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class DomainProfileService implements IProfileService {

    private final IProfileCommandRepository commandRepository;
    private final IProfileQueryRepository queryRepository;
    private final IEventService<Profile> eventService;
    private final ILogService logService;

    @Value("${kafka.messenger.profile:false}")
    private boolean messengerIsActive;

    public DomainProfileService(IProfileCommandRepository commandRepository, IProfileQueryRepository queryRepository,
                                IEventService<Profile> eventService, ILogService logService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
        this.logService = logService;
    }

    @Override
    @Transactional
    public void create(Profile profile) {
        RulesChecker.checkRule(new ProfileNameRequiredRule(profile.getName()));
        RulesChecker.checkRule(new ProfileStateRequiredRule(profile.getState()));
        RulesChecker.checkRule(new ProfileAuthorizationsRequiredRule(profile.getAuthorizations()));
        RulesChecker.checkRule(new ProfileOrganizationRequiredRule(profile.getOrganization()));
        commandRepository.create(profile);
        logService.info(String.format("New Profile created with: Id: %s and Name: %s  by the user: %s",
                profile.getId(),
                profile.getName(), UserContext.getUserSession().getUsername()), profile);
        publish(EventType.CREATED, profile);
    }



    @Override
    @Transactional
    public void update(Profile profile) {
        Profile toUpdate = queryRepository.findById(profile.getId());
        toUpdate.update(profile);
        commandRepository.update(toUpdate);
        logService.info(String.format("New Profile updated with: Id: %s and Name: %s  by the user: %s",
                toUpdate.getId(),
                toUpdate.getName(), UserContext.getUserSession().getUsername()), toUpdate);
        publish(EventType.UPDATED, toUpdate);

    }

    @Override
    @Transactional
    public void delete(UUID id) {
        Profile profile = this.findById(id);
        commandRepository.delete(profile);
        logService.info(String.format("New Profile deleted with: Id: %s and Name: %s  by the user: %s",
                profile.getId(),
                profile.getName(), UserContext.getUserSession().getUsername()), profile);
        publish(EventType.DELETED, profile);
    }

    @Override
    public Profile findById(UUID profileId) {
        return queryRepository.findById(profileId);
    }

    @Override
    public MessagePaginatedResponse getPaginatedProfiles(Pageable pageable, String filter, String name,
                                                         String description, State state, UUID organization) {
        return queryRepository.findAllProfiles(pageable, filter, name, description, state, organization);
    }

    private void publish(EventType eventType, Profile profile) {
        if (messengerIsActive) {
            eventService.publish(eventType, profile);
        }
    }

}
