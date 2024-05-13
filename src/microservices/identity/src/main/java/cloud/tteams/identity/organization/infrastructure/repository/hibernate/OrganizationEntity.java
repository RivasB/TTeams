package cloud.tteams.identity.organization.infrastructure.repository.hibernate;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.infrastructure.config.annotation.Persistent;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Persistent
@Table(name = "tteams_organization")
public class OrganizationEntity {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String contact;

    @Column
    @Enumerated(EnumType.STRING)
    private State state;

    public OrganizationEntity() {
    }

    public OrganizationEntity(Organization organization) {
        this.id = organization.getId();
        this.name = organization.getName();
        this.description = organization.getDescription();
        this.contact = organization.getContact();
        this.state = organization.getState();
    }


    public Organization toAggregate() {
        return new Organization(this.id, this.name, this.description, this.contact, this.state);
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
