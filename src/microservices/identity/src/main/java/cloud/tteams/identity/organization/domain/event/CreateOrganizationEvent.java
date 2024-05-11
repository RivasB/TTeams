package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class CreateOrganizationEvent extends Event<Organization> {

    public CreateOrganizationEvent(Organization data) {
        super(EventType.CREATED, data);
    }
}
