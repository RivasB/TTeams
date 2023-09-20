package ec.gob.registrocivil.identity.telephone_operator.domain.service;

import org.springframework.data.domain.Pageable;

import ec.gob.registrocivil.share.core.domain.MessagePaginatedResponse;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorId;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperatorName;

public interface ITelephoneOperatorService {

    public void createTelephoneOperator(TelephoneOperator operator);

    public void updateTelephoneOperator(TelephoneOperator operator);

    public void deleteTelephoneOperator(TelephoneOperatorId id);

    public TelephoneOperator findById(TelephoneOperatorId id);

    public TelephoneOperator findByName(TelephoneOperatorName name);

    public MessagePaginatedResponse getPaginatedTelephoneOperator(Pageable pageable, String filter);

    public Long countByIdIsNotAndName(TelephoneOperatorId id, TelephoneOperatorName name);
}
