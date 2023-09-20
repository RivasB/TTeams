package ec.gob.registrocivil.identity.telephone_operator.domain.event;

import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;

public class TelephoneOperatorCreatedEvent extends Event<TelephoneOperator> {

    public TelephoneOperatorCreatedEvent(TelephoneOperator data) {
        super(EventType.CREATED, data);
    }

}
