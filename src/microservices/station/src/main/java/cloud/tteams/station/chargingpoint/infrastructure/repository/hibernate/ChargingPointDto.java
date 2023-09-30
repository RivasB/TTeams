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
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "power_level", nullable = false)
    private int powerLevel;

    @ManyToOne
    @JoinColumn(name="fk_pk_station", nullable=false)
    private StationDto station;

    public ChargingPointDto() {
    }

    public ChargingPointDto(ChargingPoint chargingPoint) {
        this.id = chargingPoint.id().getValue();
        this.powerLevel = chargingPoint.powerLevel().getValue();
        this.station = new StationDto(chargingPoint.station());
    }

    public ChargingPoint toAggregate(){
        ChargingPointId id = new ChargingPointId(this.id);
        ChargingPointPowerLevel powerLevel = new ChargingPointPowerLevel(this.powerLevel);
        Station station = this.station.toAggregate();
        return new ChargingPoint(id, powerLevel,station);
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
