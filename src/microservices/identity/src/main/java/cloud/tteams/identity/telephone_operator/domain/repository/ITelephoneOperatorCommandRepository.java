package cloud.tteams.identity.telephone_operator.domain.repository;

import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;

public interface ITelephoneOperatorCommandRepository {

    public void create(TelephoneOperator operator);

    public void update(TelephoneOperator operator);

    public void delete(TelephoneOperator operator);
}
