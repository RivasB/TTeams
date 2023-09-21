package cloud.tteams.identity.aplication.domain.event;

import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AplicationCreatedEvent extends Event<Aplication> {

    public AplicationCreatedEvent(Aplication data) {
        super(EventType.CREATED, data);
    }

}
