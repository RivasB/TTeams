package cloud.tteams.station.station.infrastructure.repository.hibernate;

import cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate.ChargingPointDto;
import cloud.tteams.station.location.domain.Location;
import cloud.tteams.station.location.infrastructure.repository.hibernate.LocationDto;
import cloud.tteams.station.station.domain.*;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ev_station")
public class StationDto {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pk_location", referencedColumnName = "id")
    private LocationDto location;

    @Column(name = "charger_type")
    private StationChargerType chargerType;

    @OneToMany(mappedBy="station")
    private List<ChargingPointDto> chargingPoints;

    @Column(name = "status")
    private StationStatus status;

    public StationDto() {
    }

    public StationDto(Station station) {
        this.id = station.id().value();
        this.location = new LocationDto(station.location());
        this.chargerType = station.chargerType();
        this.chargingPoints = station.chargingPoints().getValue()
                .stream().map(ChargingPointDto::new).toList();
        this.status = station.status();
    }

    public Station toAggregate() {
        StationId id = new StationId(this.id);
        Location location = this.location.toAggregate();
        StationChargerType chargerType = this.chargerType;
        StationChargingPoints chargingPoints = new StationChargingPoints(
                this.chargingPoints.stream().map(ChargingPointDto::toAggregate).toList()
        );
        StationStatus status = this.status;
        return new Station(id,location, chargerType,chargingPoints, status);
    }

    public UUID getId() {
        return id;
    }

    public StationChargerType getChargerType() {
        return chargerType;
    }

    public StationStatus getStatus() {
        return status;
    }
    public LocationDto getLocation() {
        return location;
    }

    public List<ChargingPointDto> getChargingPoints() {
        return chargingPoints;
    }
}
