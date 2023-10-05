package cloud.tteams.station.chargingpoint.domain;

import cloud.tteams.station.station.domain.Station;

public class ChargingPoint {

    private ChargingPointId id;

    private ChargingPointPowerLevel powerLevel;

    private Station station;

    public ChargingPoint(ChargingPointId id, ChargingPointPowerLevel powerLevel, Station station) {
        this.id = id;
        this.powerLevel = powerLevel;
        this.station = station;
    }

    @Override
    public String toString() {
        return "ChargingPoint{" +
                "id=" + id +
                ", powerLevel=" + powerLevel +
                ", station=" + station +
                '}';
    }

    public ChargingPointId getId() {
        return id;
    }

    public ChargingPointPowerLevel getPowerLevel() {
        return powerLevel;
    }

    public Station getStation() {
        return station;
    }
}
