package cloud.tteams.identity.telephone_operator.domain.event;

import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;
import cloud.tteams.identity.telephone_operator.domain.TelephoneOperator;

public class TelephoneOperatorCreatedEvent extends Event<TelephoneOperator> {

    public TelephoneOperatorCreatedEvent(TelephoneOperator data) {
        super(EventType.CREATED, data);
    }

}
