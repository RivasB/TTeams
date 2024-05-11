package cloud.tteams.identity.application.domain.event;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AplicationUpdatedEvent extends Event<Aplication> {

    public AplicationUpdatedEvent(Aplication data) {
        super(EventType.UPDATED, data);
    }

}
