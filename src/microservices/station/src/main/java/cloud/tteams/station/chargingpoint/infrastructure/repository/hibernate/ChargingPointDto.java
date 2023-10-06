package cloud.tteams.station.chargingpoint.infrastructure.repository.hibernate;

import cloud.tteams.station.chargingpoint.domain.ChargingPoint;
import cloud.tteams.station.chargingpoint.domain.ChargingPointId;
import cloud.tteams.station.chargingpoint.domain.ChargingPointPowerLevel;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ev_chargingpoint")
public class ChargingPointDto {

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "power_level", nullable = false)
    private int powerLevel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_pk_station", nullable=false)
    private StationDto station;

    public ChargingPointDto() {
    }

    public ChargingPointDto(UUID id, int powerLevel, StationDto station) {
        this.id = id;
        this.powerLevel = powerLevel;
        this.station = station;
    }

    public ChargingPointDto(ChargingPoint chargingPoint) {
        this.id = chargingPoint.getId().getValue();
        this.powerLevel = chargingPoint.getPowerLevel().getValue();
        this.station = new StationDto(chargingPoint.getStation());
    }

    public ChargingPoint toAggregate(){
        ChargingPointId id = new ChargingPointId(this.id);
        ChargingPointPowerLevel powerLevel = new ChargingPointPowerLevel(this.powerLevel);
        return new ChargingPoint(id, powerLevel,null);
    }

    public UUID getId() {
        return id;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public StationDto getStation() {
        return station;
    }
}
