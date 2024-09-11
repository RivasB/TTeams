package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class UpdateOrganizationEvent extends Event<Organization> {

    public UpdateOrganizationEvent(Organization data) {
        super(EventType.UPDATED, data);
    }

}