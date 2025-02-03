package cloud.tteams.identity.organization.application.query;

import java.util.UUID;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class OrganizationResponse implements IResponse {

    private final UUID id;

    private final String name;

    private final String description;

    private final String contact;

    private final State state;

    public OrganizationResponse(Organization response) {
        this.id = response.getId();
        this.name = response.getName();
        this.description = response.getDescription();
        this.contact = response.getContact();
        this.state = response.getState();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getContact() {
        return contact;
    }

    public State getState() {
        return state;
    }
}
