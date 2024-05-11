package cloud.tteams.identity.organization.application.command.update;

import cloud.tteams.share.core.domain.State;

import java.util.UUID;

public class UpdateOrganizationRequest {

    private final UUID id;

    private final String name;

    private final String description;

    private final String contact;

    private final State state;

    public UpdateOrganizationRequest(UUID id, String name, String description, String contact, State state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.state = state;
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
