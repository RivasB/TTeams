package ec.gob.registrocivil.identity.telephone_operator.domain.event;

import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;
import ec.gob.registrocivil.identity.telephone_operator.domain.TelephoneOperator;

public class TelephoneOperatorDeletedEvent extends Event<TelephoneOperator> {

    public TelephoneOperatorDeletedEvent(TelephoneOperator data) {
        super(EventType.DELETED, data);
    }

}
