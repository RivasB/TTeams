package ec.gob.registrocivil.identity.profile.infrastructure.service;

import ec.gob.registrocivil.identity.agency.domain.AgencyId;
import ec.gob.registrocivil.identity.profile.domain.ProfileDescription;
import ec.gob.registrocivil.identity.profile.domain.ProfileName;
import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.identity.profile.domain.ProfileId;
import ec.gob.registrocivil.identity.profile.domain.repository.IProfileCommandRepository;
import ec.gob.registrocivil.identity.profile.domain.repository.IProfileQueryRepository;
import ec.gob.registrocivil.identity.profile.domain.rules.ProfileAccessRequiredRule;
import ec.gob.registrocivil.identity.profile.domain.rules.ProfileAgencyRequiredRule;
import ec.gob.registrocivil.identity.profile.domain.rules.ProfileNameRequiredRule;
import ec.gob.registrocivil.identity.profile.domain.rules.ProfileStateRequiredRule;
import ec.gob.registrocivil.identity.profile.domain.service.IProfileService;
import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.share.core.domain.RulesChecker;
import ec.gob.registrocivil.share.core.domain.service.IEventService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DomainProfileService implements IProfileService {

    private final IProfileCommandRepository commandRepository;
    private final IProfileQueryRepository queryRepository;
    private final IEventService<Profile> eventService;

    @Value("${kafka.messenger.profile:false}")
    private boolean messengerIsActive;

    public DomainProfileService(IProfileCommandRepository commandRepository, IProfileQueryRepository queryRepository,
            IEventService<Profile> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    @Transactional
    public void create(Profile profile) {
        RulesChecker.checkRule(new ProfileNameRequiredRule(profile.getName().value()));
        RulesChecker.checkRule(new ProfileAgencyRequiredRule(profile.getAgency().getId().value()));
        RulesChecker.checkRule(new ProfileStateRequiredRule(profile.getState()));
        RulesChecker.checkRule(new ProfileAccessRequiredRule(profile.getAccess().value()));

        commandRepository.create(profile);

        if (messengerIsActive) {
            eventService.create(profile);
        }
    }

    @Override
    @Transactional
    public void update(Profile profile) {
        Profile toUpdate = queryRepository.findById(profile.getId());
        RulesChecker.checkRule(new ProfileNameRequiredRule(profile.getName().value()));
        RulesChecker.checkRule(new ProfileAgencyRequiredRule(profile.getAgency().getId().value()));
        RulesChecker.checkRule(new ProfileStateRequiredRule(profile.getState()));
        RulesChecker.checkRule(new ProfileAccessRequiredRule(profile.getAccess().value()));
        Profile updated = new Profile(toUpdate.getId(), profile.getName(), profile.getDescription(), profile.getState(),
                profile.getAgency(), toUpdate.getUser(), profile.getAccess());
        commandRepository.update(updated);

        if (messengerIsActive) {
            eventService.update(updated);
        }

    }

    @Override
    @Transactional
    public void delete(ProfileId id) {
        Profile profile = queryRepository.findById(id);
        commandRepository.delete(profile);
        if (messengerIsActive) {
            eventService.delete(profile);
        }
    }

    @Override
    public Profile findById(ProfileId profileId) {
        return queryRepository.findById(profileId);
    }

    @Override
    public MessagePaginatedResponse getPaginatedProfiles(Pageable pageable, String filter, ProfileName name,
                                                         ProfileDescription description, ProfileState state,
                                                         AgencyId agencyId) {
        return queryRepository.findAllProfiles(pageable, filter, name, description, state, agencyId);
    }

}
