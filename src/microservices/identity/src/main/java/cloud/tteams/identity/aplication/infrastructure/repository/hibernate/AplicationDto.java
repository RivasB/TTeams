package cloud.tteams.identity.aplication.infrastructure.repository.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import cloud.tteams.identity.access.domain.Access;
import cloud.tteams.identity.access.infrastructure.repository.hibernate.AccessDto;
import cloud.tteams.identity.aplication.domain.Aplication;
import cloud.tteams.identity.aplication.domain.AplicationAccessSet;
import cloud.tteams.identity.aplication.domain.AplicationDescription;
import cloud.tteams.identity.aplication.domain.AplicationId;
import cloud.tteams.identity.aplication.domain.AplicationName;
import cloud.tteams.identity.aplication.domain.AplicationState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_aplication")
public class AplicationDto {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private AplicationState state;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private Set<AccessDto> access;

    public AplicationDto() {
    }

    public AplicationDto(UUID id, String name, String description, AplicationState state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.state = state;
        this.access = new HashSet<>();
    }

    public AplicationDto(Aplication aplication) {
        this.id = aplication.getId().getValue();
        this.name = aplication.getName().getValue();
        this.description = aplication.getDescription().getValue();
        this.state = aplication.getState();
        this.access = new HashSet<>();
        if (aplication.getAccess() != null) {
            aplication.getAccess().getValue().stream().forEach(element -> {
                access.add(new AccessDto(element));
            });
        }

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

    public AplicationState getState() {
        return state;
    }

    public Set<AccessDto> getAccess() {
        return access;
    }

    public Aplication toAggregate() {
        AplicationId uId = new AplicationId(getId());
        AplicationName uName = new AplicationName(getName());
        AplicationDescription uDescription = new AplicationDescription(getDescription());
        AplicationState uState = getState();
        Collection<Access> uAccess = new ArrayList<>();
        if (this.access != null) {
            this.access.stream().forEach(element -> uAccess.add(element.toAggregate()));
        }
        AplicationAccessSet uAccessSet = new AplicationAccessSet(uAccess);

        return new Aplication(uId, uName, uDescription, uState, uAccessSet);
    }

}
