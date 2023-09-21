package cloud.tteams.identity.telephone_operator.infrastructure.adapter.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import cloud.tteams.identity.telephone_operator.infrastructure.exception.TelephoneOperatorNotFoundException;
import cloud.tteams.identity.telephone_operator.infrastructure.repository.hibernate.TelephoneOperatorDto;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.identity.telephone_operator.application.TelephoneOperatorResponse;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorName;
import cloud.tteams.identity.telephone_operator.domain.repository.ITelephoneOperatorQueryRepository;

@Component
@Primary
public class PostgresDBTelephoneOperatorQueryRepository implements ITelephoneOperatorQueryRepository {

    private final ISpringTelephoneOperatorReadDataJPARepository operatorRepository;

    public PostgresDBTelephoneOperatorQueryRepository(
            ISpringTelephoneOperatorReadDataJPARepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    @Override
    public Optional<TelephoneOperator> findById(TelephoneOperatorId id) {
        TelephoneOperatorDto entity = operatorRepository.findById(id.value())
                .orElseThrow(TelephoneOperatorNotFoundException::new);

        return Optional.of(entity.toAggregate());
    }

    @Override
    public Optional<TelephoneOperator> findByName(TelephoneOperatorName name) {
        TelephoneOperatorDto entity = operatorRepository.findByName(name.value())
                .orElseThrow(TelephoneOperatorNotFoundException::new);

        return Optional.of(entity.toAggregate());
    }

    @Override
    public MessagePaginatedResponse allTelephoneOperatorWithOutFilter(Pageable pageable) {
        Page<TelephoneOperatorDto> page = operatorRepository.findAll(pageable);
        return this.result(page);
    }

    @Override
    public MessagePaginatedResponse allTelephoneOperatorWithFilter(Pageable pageable, String filter) {
        Page<TelephoneOperatorDto> page = operatorRepository
                .getTelephoneOperatorDtoByNameContainingIgnoreCase(filter, pageable);

        return this.result(page);
    }

    @Override
    public Long countByIdIsNotAndName(UUID id, String name) {
        return operatorRepository.countByIdIsNotAndName(id, name);
    }

    /*
     * Usado por los metodos: allTelephoneOperatorWithOutFilter y
     * allTelephoneOperatorWithFilter
     */
    private MessagePaginatedResponse result(Page<TelephoneOperatorDto> page) {
        List<TelephoneOperatorResponse> responses = new ArrayList<>();

        page.forEach(v -> responses.add(new TelephoneOperatorResponse(v.getId(), v.getName())));

        return new MessagePaginatedResponse("OK", responses, page.getTotalPages(), page.getNumberOfElements(),
                page.getTotalElements(), page.getSize(), page.getNumber());
    }

}
