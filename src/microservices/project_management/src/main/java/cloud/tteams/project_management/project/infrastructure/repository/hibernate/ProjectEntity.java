package cloud.tteams.project_management.project.infrastructure.repository.hibernate;

import cloud.tteams.project_management.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import cloud.tteams.project_management.location.domain.Location;
import cloud.tteams.project_management.location.infrastructure.repository.hibernate.LocationDto;
import cloud.tteams.project_management.project.domain.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ev_station")
public class ProjectEntity {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @OneToOne(mappedBy = "project_management", cascade = CascadeType.ALL)
    private LocationDto location;

    @Column(name = "charger_type")
    private StationChargerType chargerType;

    @OneToMany(mappedBy="project_management",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ChargingPointDto> chargingPoints;

    @Column(name = "status")
    private ProjectStatus status;

    public ProjectEntity() {
    }

    public ProjectEntity(Project project) {
        this.id = project.getId().value();
        this.location = project.getLocation() != null ? new LocationDto(project.getLocation()) : null;
        this.chargerType = project.getChargerType();
        this.chargingPoints = project.getChargingPoints().getValue()
                .stream().map(ChargingPointDto::new).toList();
        this.status = project.getStatus();
    }

    public Project toAggregate() {
        ProjectId id = new ProjectId(this.id);
        Location location = this.location.toAggregate();
        StationChargerType chargerType = this.chargerType;
        StationChargingPoints chargingPoints = new StationChargingPoints(
                this.chargingPoints.stream().map(ChargingPointDto::toAggregate).toList()
        );
        ProjectStatus status = this.status;
        return new Project(id,location, chargerType,chargingPoints, status);
    }

    public Project toAggregateReference() {
        ProjectId id = new ProjectId(this.id);
        StationChargerType chargerType = this.chargerType;
        StationChargingPoints chargingPoints = new StationChargingPoints(
                this.chargingPoints.stream().map(ChargingPointDto::toAggregate).toList()
        );
        ProjectStatus status = this.status;
        return new Project(id,null, chargerType,chargingPoints, status);
    }

    public UUID getId() {
        return id;
    }

    public StationChargerType getChargerType() {
        return chargerType;
    }

    public ProjectStatus getStatus() {
        return status;
    }
    public LocationDto getLocation() {
        return location;
    }

    public List<ChargingPointDto> getChargingPoints() {
        return chargingPoints;
    }
}
