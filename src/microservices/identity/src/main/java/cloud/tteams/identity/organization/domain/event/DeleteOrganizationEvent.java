package cloud.tteams.identity.organization.domain.event;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.event.Event;
import cloud.tteams.share.core.domain.event.EventType;

public class DeleteOrganizationEvent extends Event<Organization> {

    public DeleteOrganizationEvent(Organization data) {
        super(EventType.DELETED, data);
    }

}
