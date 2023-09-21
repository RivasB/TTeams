package cloud.tteams.identity.telephone_operator.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.share.core.domain.RulesChecker;
import cloud.tteams.share.core.domain.service.IEventService;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorName;
import cloud.tteams.identity.telephone_operator.domain.repository.ITelephoneOperatorCommandRepository;
import cloud.tteams.identity.telephone_operator.domain.repository.ITelephoneOperatorQueryRepository;
import cloud.tteams.identity.telephone_operator.domain.rules.TelephoneOperatorNameMustBeRequiredRule;
import cloud.tteams.identity.telephone_operator.domain.rules.TelephoneOperatorNameMustBeUniqueRule;
import cloud.tteams.identity.telephone_operator.domain.service.ITelephoneOperatorService;
import cloud.tteams.identity.telephone_operator.infrastructure.exception.TelephoneOperatorNotFoundException;

public class DomainTelephoneOperatorService implements ITelephoneOperatorService {

    private final ITelephoneOperatorCommandRepository commandRepository;
    private final ITelephoneOperatorQueryRepository queryRepository;
    private final IEventService<TelephoneOperator> eventService;

    @Value("${kafka.messenger.telephone_operator:false}")
    private boolean messengerIsActive;

    public DomainTelephoneOperatorService(
            ITelephoneOperatorCommandRepository commandRepository,
            ITelephoneOperatorQueryRepository queryRepository,
            IEventService<TelephoneOperator> eventService) {

        this.commandRepository = commandRepository;
        this.queryRepository = queryRepository;
        this.eventService = eventService;
    }

    @Override
    public void createTelephoneOperator(TelephoneOperator operator) {
        RulesChecker.checkRule(new TelephoneOperatorNameMustBeRequiredRule(operator.getName()));
        RulesChecker.checkRule(new TelephoneOperatorNameMustBeUniqueRule(this, operator));

        commandRepository.create(operator);

        if (messengerIsActive) {
            eventService.create(operator);
        }
    }

    @Override
    public void updateTelephoneOperator(TelephoneOperator operator) {
        TelephoneOperator toUpdate = this.findById(operator.getId());

        TelephoneOperatorName name = (operator.getName() == null || operator.getName().value() == null)
                ? toUpdate.getName()
                : operator.getName();

        TelephoneOperator operatorSave = new TelephoneOperator(operator.getId(), name);

        RulesChecker.checkRule(new TelephoneOperatorNameMustBeRequiredRule(operatorSave.getName()));
        RulesChecker.checkRule(new TelephoneOperatorNameMustBeUniqueRule(this, operatorSave));

        commandRepository.update(operatorSave);

        if (messengerIsActive) {
            eventService.update(operatorSave);
        }
    }

    @Override
    public void deleteTelephoneOperator(TelephoneOperatorId id) {

        TelephoneOperator operator = this.findById(id);
        commandRepository.delete(operator);

        if (messengerIsActive) {
            eventService.delete(operator);
        }
    }

    @Override
    public TelephoneOperator findById(TelephoneOperatorId id) {
        return queryRepository.findById(id).orElseThrow(TelephoneOperatorNotFoundException::new);
    }

    @Override
    public TelephoneOperator findByName(TelephoneOperatorName name) {
        return queryRepository.findByName(name).orElseThrow(TelephoneOperatorNotFoundException::new);
    }

    @Override
    public MessagePaginatedResponse getPaginatedTelephoneOperator(Pageable pageable, String filter) {
        if (isValid(filter)) {
            return queryRepository.allTelephoneOperatorWithFilter(pageable, filter);
        }

        return queryRepository.allTelephoneOperatorWithOutFilter(pageable);
    }

    @Override
    public Long countByIdIsNotAndName(TelephoneOperatorId id, TelephoneOperatorName name) {
        return queryRepository.countByIdIsNotAndName(id.value(), name.value());
    }

    private boolean isValid(String str) {
        return str == null || str.isEmpty() || str.isBlank();
    }
}
