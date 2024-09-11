package cloud.tteams.identity.organization.infrastructure.repository.hibernate;

import cloud.tteams.identity.organization.domain.Organization;
import cloud.tteams.identity.profile.infrastructure.repository.hibernate.ProfileEntity;
import cloud.tteams.share.core.domain.State;
import cloud.tteams.share.core.infrastructure.config.annotation.Persistent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private List<ProfileEntity> profiles;

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
        this.profiles = new ArrayList<>();
        if (organization.getProfiles() != null) {
            organization.getProfiles().forEach(element ->
                    profiles.add(new ProfileEntity(element)));
        }
        this.state = organization.getState();
    }


    public Organization toAggregate() {
        return new Organization(this.id, this.name, this.description, this.contact,
                this.profiles.stream().map(ProfileEntity::toAggregate).toList(), this.state);
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
