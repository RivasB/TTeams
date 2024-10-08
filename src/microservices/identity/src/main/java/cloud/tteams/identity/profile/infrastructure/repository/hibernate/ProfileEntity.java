package cloud.tteams.identity.profile.infrastructure.repository.hibernate;

import java.util.*;

import cloud.tteams.identity.authorization.infrastructure.repository.hibernate.AuthorizationEntity;
import cloud.tteams.identity.organization.infrastructure.repository.hibernate.OrganizationEntity;
import cloud.tteams.identity.user.infrastructure.repository.hibernate.UserEntity;
import cloud.tteams.identity.profile.domain.Profile;
import cloud.tteams.share.core.domain.State;
import jakarta.persistence.*;

@Entity
@Table(name = "tteams_profile")
public class ProfileEntity {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pk_organization", nullable = false)
    private OrganizationEntity organization;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name = "tteams_mtm_profile_authorization",
            joinColumns = @JoinColumn(name = "fk_pk_profile"),
            inverseJoinColumns = @JoinColumn(name = "fk_pk_authorization"))
    private Set<AuthorizationEntity> authorizations= new HashSet<>();

    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private Set<UserEntity> users = new HashSet<>();

    @PreRemove
    private void removeUserAssociations() {
        for (UserEntity user: this.users) {
            user.removeProfile();
        }
    }

    public ProfileEntity() {
    }

    public ProfileEntity(Profile profile) {
        Optional.ofNullable(profile.getId()).ifPresent(value -> this.id = value);
        Optional.ofNullable(profile.getName()).ifPresent(value -> this.name = value);
        Optional.ofNullable(profile.getDescription()).ifPresent(value -> this.description = value);
        Optional.ofNullable(profile.getOrganization()).ifPresent(value -> this.organization = new OrganizationEntity(value));
        Optional.ofNullable(profile.getState()).ifPresent(value -> this.state = value);
        Optional.ofNullable(profile.getAuthorizations()).ifPresent(authorizationsList -> {
            if (Objects.isNull(this.authorizations)) {
                this.authorizations = new HashSet<>();
            } else {
                this.authorizations.clear();
            }
            authorizationsList.forEach(element ->
                    this.authorizations.add(new AuthorizationEntity(element))
            );
        });
    }

    public Profile toAggregate() {
        return new Profile(this.id, this.name, this.description, this.organization.toAggregate(), this.state,
                this.authorizations.stream().map(AuthorizationEntity::toAggregate).toList(),
                new ArrayList<>());
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

    public State getState() {
        return state;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public Set<AuthorizationEntity> getAuthorizations() {
        return authorizations;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }
}
