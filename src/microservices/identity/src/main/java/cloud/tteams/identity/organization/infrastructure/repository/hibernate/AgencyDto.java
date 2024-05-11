package cloud.tteams.identity.organization.infrastructure.repository.hibernate;

import java.util.UUID;

import cloud.tteams.identity.geographiclocation.domain.GeographicLocation;
import cloud.tteams.identity.geographiclocation.infrastructure.repository.hibernate.GeographicLocationDto;
import cloud.tteams.identity.organization.domain.Agency;
import cloud.tteams.identity.organization.domain.AgencyDescription;
import cloud.tteams.identity.organization.domain.AgencyId;
import cloud.tteams.identity.organization.domain.AgencyLatitude;
import cloud.tteams.identity.organization.domain.AgencyLongitude;
import cloud.tteams.identity.organization.domain.AgencyName;
import cloud.tteams.identity.organization.domain.AgencyRegion;
import cloud.tteams.identity.organization.domain.AgencyState;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jpa_agency")
public class AgencyDto {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "country", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private GeographicLocationDto country;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "province", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private GeographicLocationDto province;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "canton", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private GeographicLocationDto canton;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "parroquia", nullable = true)
    private GeographicLocationDto parroquia;

    @Column
    private String region;

    @Column
    @Enumerated(EnumType.STRING)
    private AgencyState state;

    @Column
    private String latitude;

    @Column
    private String longitude;

    public AgencyDto() {
    }

    public AgencyDto(UUID id, String name, String description, GeographicLocationDto country,
            GeographicLocationDto province, GeographicLocationDto canton, GeographicLocationDto parroquia,
            String region, AgencyState state, String latitude, String longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.province = province;
        this.canton = canton;
        this.parroquia = parroquia;
        this.region = region;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AgencyDto(Agency agency) {
        this.id = agency.getId().getValue();
        this.name = agency.getName().getValue();
        this.description = agency.getDescription().getValue();
        this.country = new GeographicLocationDto(agency.getCountry());
        this.province = new GeographicLocationDto(agency.getProvince());
        this.canton = new GeographicLocationDto(agency.getCanton());
        this.parroquia = new GeographicLocationDto(agency.getParroquia());
        this.region = agency.getRegion().getValue();
        this.state = agency.getState();
        this.latitude = agency.getLatitute().getValue();
        this.longitude = agency.getLongitude().getValue();
    }

    public Agency toAggregate() {
        AgencyId uId = new AgencyId(getId());
        AgencyName uName = new AgencyName(getName());
        AgencyDescription uDescription = new AgencyDescription(getDescription());
        GeographicLocation uCountry = getCountry() != null ? getCountry().toAggregate() : null;
        GeographicLocation uProvince = getProvince() != null ? getProvince().toAggregate() : null;
        GeographicLocation uCanton = getCanton() != null ? getCanton().toAggregate() : null;
        GeographicLocation uParroquia = getParroquia() != null ? getParroquia().toAggregate() : null;
        AgencyRegion uregion = new AgencyRegion(getRegion());
        AgencyState uState = getState();
        AgencyLatitude uLatitude = new AgencyLatitude(getLatitude());
        AgencyLongitude uLongitude = new AgencyLongitude(getLongitude());

        return new Agency(uId, uName, uDescription, uCountry, uProvince, uCanton, uParroquia, uregion, uState,
                uLatitude, uLongitude);
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

    public GeographicLocationDto getCountry() {
        return country;
    }

    public GeographicLocationDto getProvince() {
        return province;
    }

    public GeographicLocationDto getCanton() {
        return canton;
    }

    public GeographicLocationDto getParroquia() {
        return parroquia;
    }

    public String getRegion() {
        return region;
    }

    public AgencyState getState() {
        return state;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

}
