package ec.gob.registrocivil.identity.profile.domain.event;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class ProfileUpdatedEvent extends Event<Profile> {

    public ProfileUpdatedEvent(Profile data) {
        super(EventType.UPDATED, data);
    }

}
