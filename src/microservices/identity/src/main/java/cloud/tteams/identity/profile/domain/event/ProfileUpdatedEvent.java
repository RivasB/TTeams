package cloud.tteams.identity.profile.domain.event;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class ProfileUpdatedEvent extends Event<Profile> {

    public ProfileUpdatedEvent(Profile data) {
        super(EventType.UPDATED, data);
    }

}
