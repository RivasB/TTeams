package ec.gob.registrocivil.identity.profile.domain.event;

import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.share.core.domain.event.Event;
import ec.gob.registrocivil.share.core.domain.event.EventType;

public class ProfileDeletedEvent extends Event<Profile> {

    public ProfileDeletedEvent(Profile data) {
        super(EventType.DELETED, data);
    }

}
