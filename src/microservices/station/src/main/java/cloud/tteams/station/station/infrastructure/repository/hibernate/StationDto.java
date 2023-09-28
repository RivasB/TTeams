package cloud.tteams.station.station.infrastructure.repository.hibernate;

import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationId;
import cloud.tteams.station.station.domain.StationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name = "ev_station")
public class StationDto {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "charger_type")
    private StationChargerType chargerType;

    @Column(name = "status")
    private StationStatus status;

    public StationDto() {
    }

    public StationDto(Station station) {
        this.id = station.id().value();
        this.chargerType = station.chargerType();
        this.status = station.status();
    }

    public Station toAggregate() {
        StationId id = new StationId(this.id);
        StationChargerType chargerType = this.chargerType;
        StationStatus status = this.status;
        return new Station(id,chargerType,status);
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
}
