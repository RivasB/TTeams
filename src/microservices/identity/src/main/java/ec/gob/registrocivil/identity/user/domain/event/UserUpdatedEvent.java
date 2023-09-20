package ec.gob.registrocivil.identity.user.domain.event;

import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;
import ec.gob.registrocivil.identity.user.domain.User;

public class UserUpdatedEvent extends Event<User> {

    public UserUpdatedEvent(User data) {
        super(EventType.UPDATED, data);
    }
}
