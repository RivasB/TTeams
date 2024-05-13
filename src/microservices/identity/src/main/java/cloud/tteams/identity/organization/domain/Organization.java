package cloud.tteams.identity.organization.domain;
import cloud.tteams.share.core.domain.AggregateRoot;
import cloud.tteams.share.core.domain.State;

import java.util.Optional;
import java.util.UUID;

public final class Organization extends AggregateRoot<Organization> {
    private final UUID id;
    private String name;
    private String description;
    private String contact;
    private State state;

    public Organization(UUID id, String name, String description, String contact, State state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contact = contact;
        this.state = state;
    }

    @Override
    public void update(Organization organization){
        Optional.ofNullable(organization.getName()).ifPresent(valor ->
                this.name = valor);
        Optional.ofNullable(organization.getDescription()).ifPresent(valor ->
                this.description = valor);
        Optional.ofNullable(organization.getContact()).ifPresent(valor ->
                this.contact = valor);
        Optional.ofNullable(organization.getState()).ifPresent(valor ->
                this.state = valor);
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
