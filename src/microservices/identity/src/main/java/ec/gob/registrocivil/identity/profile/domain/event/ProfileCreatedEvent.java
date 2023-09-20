package ec.gob.registrocivil.identity.profile.domain.event;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class ProfileCreatedEvent extends Event<Profile> {

    public ProfileCreatedEvent(Profile data) {
        super(EventType.CREATED, data);
    }
}
