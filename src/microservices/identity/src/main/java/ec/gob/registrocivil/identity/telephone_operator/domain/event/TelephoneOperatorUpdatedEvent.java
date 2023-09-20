package ec.gob.registrocivil.identity.telephone_operator.domain.event;

import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;

public class TelephoneOperatorUpdatedEvent extends Event<TelephoneOperator> {

    public TelephoneOperatorUpdatedEvent(TelephoneOperator data) {
        super(EventType.UPDATED, data);
    }

}
