package cloud.tteams.identity.application.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.identity.application.domain.AplicationAccessSet;
import cloud.tteams.identity.application.domain.AplicationDescription;
import cloud.tteams.identity.application.domain.AplicationId;
import cloud.tteams.identity.application.domain.AplicationName;
import cloud.tteams.identity.application.domain.AplicationState;
import cloud.tteams.identity.application.domain.repository.IAplicationCommandRepository;
import cloud.tteams.identity.application.domain.repository.IAplicationQueryRepository;
import cloud.tteams.identity.application.domain.rules.ApplicationAccessRequiredRule;
import cloud.tteams.identity.application.domain.rules.ApplicationNameMustBeUniqueRule;
import cloud.tteams.identity.application.domain.rules.ApplicationNameRequiredRule;
import cloud.tteams.identity.application.domain.rules.ApplicationStateRequiredRule;
import cloud.tteams.identity.application.domain.service.IAplicationService;
import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;

public class DomainAplicationService implements IAplicationService {
    private final IAplicationCommandRepository commandRepository;
    private final IAplicationQueryRepository queryRepository;
    private final IEventService<Aplication> eventService;

    @Value("${kafka.messenger.application:false}")
    private boolean messengerIsActive;

    public DomainAplicationService(IAplicationCommandRepository commandRepository,
            IAplicationQueryRepository queryRepository, IEventService<Aplication> eventService) {
        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void createAplication(Aplication aplication) {
        RulesChecker.checkRule(new ApplicationNameRequiredRule(aplication.getName().value()));
        RulesChecker.checkRule(new ApplicationNameMustBeUniqueRule(this, aplication));
        RulesChecker.checkRule(new ApplicationStateRequiredRule(aplication.getState()));
        RulesChecker.checkRule(new ApplicationAccessRequiredRule(aplication.getAccess()));

        commandRepository.create(aplication);

        if (messengerIsActive) {
            eventService.create(aplication);
        }
    }

    @Override
    public void delete(AplicationId id) {
        Aplication aplicationDelete = queryRepository.findById(id);

        if (aplicationDelete.getState().equals(AplicationState.ACTIVE)) {
            AplicationId dId = new AplicationId(aplicationDelete.getId().getValue());
            AplicationName dName = new AplicationName(aplicationDelete.getName().getValue());
            AplicationDescription dDescription = new AplicationDescription(
                    aplicationDelete.getDescription().getValue());
            AplicationState dState = AplicationState.INACTIVE;

            Aplication dAplication = new Aplication(dId, dName, dDescription, dState, null);
            commandRepository.update(dAplication);
        } else
            commandRepository.delete(aplicationDelete);
        if (messengerIsActive) {
            eventService.delete(aplicationDelete);
        }
    }

    @Override
    public void updateAplication(Aplication aplication) {
        AplicationId id = aplication.getId();
        Aplication toUpdate = queryRepository.findById(id);

        AplicationName name = (null == aplication.getName() || aplication.getName().value().isBlank())
                ? toUpdate.getName()
                : aplication.getName();

        AplicationDescription description = aplication.getDescription() == null ? toUpdate.getDescription()
                : aplication.getDescription();
        AplicationState state = aplication.getState() == null ? toUpdate.getState() : aplication.getState();
        AplicationAccessSet access = aplication.getAccess() == null ? toUpdate.getAccess() : aplication.getAccess();

        Aplication aplicationSave = new Aplication(id, name, description, state, access);

        RulesChecker.checkRule(new ApplicationNameRequiredRule(aplication.getName().value()));
        RulesChecker.checkRule(new ApplicationNameMustBeUniqueRule(this, aplication));
        RulesChecker.checkRule(new ApplicationStateRequiredRule(aplication.getState()));
        RulesChecker.checkRule(new ApplicationAccessRequiredRule(aplication.getAccess()));

        commandRepository.update(aplicationSave);

        if (messengerIsActive) {
            eventService.update(aplicationSave);
        }
    }

    @Override
    public Aplication findById(AplicationId id) {
        return queryRepository.findById(id);
    }

    @Override
    public MessagePaginatedResponse getPaginatedAplication(Pageable pageable, String filter) {
        if (!"".equals(filter)) {
            return this.queryRepository.allAplicationWithFilter(pageable, filter);
        }

        return this.queryRepository.allAplicationWithOutFilter(pageable);
    }

    @Override
    public Long countByName(AplicationName name) {
        return queryRepository.countByName(name.value());
    }

    @Override
    public Aplication findByName(AplicationName name) {
        return queryRepository.findByName(name.value());
    }

    @Override
    public Long countByIdIsNotAndName(AplicationId id, AplicationName name) {
        return queryRepository.countByIdIsNotAndName(id.value(), name.value());
    }
}
