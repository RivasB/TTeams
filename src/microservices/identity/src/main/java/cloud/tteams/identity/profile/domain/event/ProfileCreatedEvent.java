package cloud.tteams.identity.profile.domain.event;

import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class ProfileCreatedEvent extends Event<Profile> {

    public ProfileCreatedEvent(Profile data) {
        super(EventType.CREATED, data);
    }
}
