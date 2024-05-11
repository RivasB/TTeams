package cloud.tteams.identity.application.domain.event;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AplicationCreatedEvent extends Event<Aplication> {

    public AplicationCreatedEvent(Aplication data) {
        super(EventType.CREATED, data);
    }

}
