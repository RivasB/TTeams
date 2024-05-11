package cloud.tteams.identity.application.domain.event;

import cloud.tteams.identity.application.domain.Aplication;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class AplicationDeletedEvent extends Event<Aplication> {

    public AplicationDeletedEvent(Aplication data) {
        super(EventType.DELETED, data);
    }

}
