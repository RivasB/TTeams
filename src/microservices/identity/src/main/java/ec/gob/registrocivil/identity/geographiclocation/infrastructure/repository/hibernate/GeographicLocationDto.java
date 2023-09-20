package ec.gob.registrocivil.identity.geographiclocation.infrastructure.repository.hibernate;

import java.util.UUID;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationId;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationName;
import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_geographic_location")
public class GeographicLocationDto {

    @Id
    @Column
    private UUID id;

    @Column(unique = false, nullable = false)
    private String name;

    @Column(nullable = false)
    private GeographicLocationType type;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_pk_geographic_location", nullable = true)
    private GeographicLocationDto parent;

    public GeographicLocationDto() {
    }

    public GeographicLocationDto(UUID id, String name, GeographicLocationType type, GeographicLocationDto parent) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.parent = parent != null ? parent : null;
    }

    public GeographicLocationDto(GeographicLocation geographiclocation) {
        this.id = geographiclocation.getId().getValue();
        this.name = geographiclocation.getName().getValue();
        this.type = geographiclocation.getType();
        this.parent = geographiclocation.getParent() != null
                ? new GeographicLocationDto(geographiclocation.getParent())
                : null;
    }

    public GeographicLocation toAggregate() {
        GeographicLocationId aId = new GeographicLocationId(id);
        GeographicLocationName aName = new GeographicLocationName(name);
        GeographicLocationType aType = type;
        GeographicLocation aParent = parent != null ? parent.toAggregate() : null;
        return new GeographicLocation(aId, aName, aType, aParent);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GeographicLocationType getType() {
        return type;
    }

    public GeographicLocationDto getParent() {
        return parent;
    }

}
