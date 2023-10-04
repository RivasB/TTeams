package cloud.tteams.station.station.domain;


import cloud.tteams.station.location.domain.Location;

public class Station {
    private StationId id;
    private Location location;
    private StationChargerType chargerType;
    private StationChargingPoints chargingPoints;
    private StationStatus status;

    public Station(StationId id, Location location, StationChargerType chargerType, StationChargingPoints chargingPoints, StationStatus status) {
        this.id = id;
        this.location = location;
        this.chargerType = chargerType;
        this.chargingPoints = chargingPoints;
        this.status = status;
    }

    public StationId getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public StationChargerType getChargerType() {
        return chargerType;
    }

    public StationChargingPoints getChargingPoints() {
        return chargingPoints;
    }

    public StationStatus getStatus() {
        return status;
    }
}
