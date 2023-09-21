package cloud.tteams.identity.profile.domain.event;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class ProfileDeletedEvent extends Event<Profile> {

    public ProfileDeletedEvent(Profile data) {
        super(EventType.DELETED, data);
    }

}
