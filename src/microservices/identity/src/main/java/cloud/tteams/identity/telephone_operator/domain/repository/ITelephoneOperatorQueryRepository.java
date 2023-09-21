package cloud.tteams.identity.telephone_operator.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import cloud.tteams.share.core.domain.MessagePaginatedResponse;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorId;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperatorName;

public interface ITelephoneOperatorQueryRepository {

    public Optional<TelephoneOperator> findById(TelephoneOperatorId id);

    public Optional<TelephoneOperator> findByName(TelephoneOperatorName name);

    public MessagePaginatedResponse allTelephoneOperatorWithOutFilter(Pageable pageable);

    public MessagePaginatedResponse allTelephoneOperatorWithFilter(Pageable pageable, String filter);

    public Long countByIdIsNotAndName(UUID id, String name);
}
