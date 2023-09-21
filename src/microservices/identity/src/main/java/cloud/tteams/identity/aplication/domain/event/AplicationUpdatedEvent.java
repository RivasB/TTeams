package cloud.tteams.identity.aplication.domain.event;

import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AplicationUpdatedEvent extends Event<Aplication> {

    public AplicationUpdatedEvent(Aplication data) {
        super(EventType.UPDATED, data);
    }

}
