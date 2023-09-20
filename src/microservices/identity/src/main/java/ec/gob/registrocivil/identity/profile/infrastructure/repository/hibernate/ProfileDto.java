package ec.gob.registrocivil.identity.profile.infrastructure.repository.hibernate;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import ec.gob.registrocivil.identity.access.infrastructure.repository.hibernate.AccessDto;
import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.infrastructure.repository.hibernate.AgencyDto;
import ec.gob.registrocivil.identity.profile.domain.Profile;
import ec.gob.registrocivil.identity.profile.domain.ProfileAccessSet;
import ec.gob.registrocivil.identity.profile.domain.ProfileDescription;
import ec.gob.registrocivil.identity.profile.domain.ProfileId;
import ec.gob.registrocivil.identity.profile.domain.ProfileName;
import ec.gob.registrocivil.identity.profile.domain.ProfileState;
import ec.gob.registrocivil.identity.user.domain.User;
import ec.gob.registrocivil.identity.user.infrastructure.repository.hibernate.UserDto;
import jakarta.persistence.*;

@Entity
@Table(name = "jpa_profile")
public class ProfileDto {

    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @Column()
    @Enumerated(EnumType.STRING)
    private ProfileState state;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pk_agency", nullable = false)
    private AgencyDto agency;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pk_user", nullable = true)
    private UserDto user;

    @ManyToMany(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "jpa_mtm_profile_access",
            joinColumns = @JoinColumn(name = "fk_pk_profile"),
            inverseJoinColumns = @JoinColumn(name = "fk_pk_access"))
    private Set<AccessDto> access;

    @ManyToMany(mappedBy = "profiles", fetch = FetchType.LAZY)
    private Set<UserDto> users = new HashSet<>();

    @PreRemove
    private void removeUserAssociations() {
        for (UserDto user: this.users) {
            user.getProfiles().remove(this);
        }
    }

    public ProfileDto() {
    }

    public ProfileDto(UUID id, String name, String description, ProfileState state, UserDto user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.user = user;
        this.access = new HashSet<>();
    }

    public ProfileDto(Profile profile) {
        this.id = profile.getId().getValue();
        this.name = profile.getName().getValue();
        this.description = profile.getDescription().getValue();
        this.state = profile.getState();
        this.agency = profile.getAgency() != null ? new AgencyDto(profile.getAgency()) : null;
        this.user = profile.getUser() != null ? new UserDto(profile.getUser()) : null;

        this.access = new HashSet<>();
        if (profile.getAccess() != null) {
            profile.getAccess().value().forEach(element -> access.add(new AccessDto(element)));
        }
    }

    public Profile toAggregate() {
        ProfileId pId = new ProfileId(this.id);
        ProfileName pName = new ProfileName(this.name);
        ProfileDescription pDescription = new ProfileDescription(this.description);
        ProfileState pState = this.state;
        ProfileAccessSet pAccess = new ProfileAccessSet(new HashSet<>());
        if (this.access != null) {
            this.access.forEach(element -> pAccess.getValue().add(element.toAggregate()));
        }
        Agency pAgency = this.agency != null ? this.agency.toAggregate() : null;
        User pUser = this.user != null ? this.user.toAggregate() : null;

        return new Profile(pId, pName, pDescription, pState, pAgency, pUser, pAccess);
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

    public ProfileState getState() {
        return state;
    }

    public AgencyDto getAgency() {
        return agency;
    }

    public UserDto getUser() {
        return user;
    }

    public Set<AccessDto> getAccess() {
        return access;
    }

}
