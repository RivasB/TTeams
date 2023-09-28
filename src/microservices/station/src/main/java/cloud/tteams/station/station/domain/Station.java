package cloud.tteams.station.station.domain;


import cloud.tteams.station.location.domain.Location;

public record Station(StationId id, Location location, StationChargerType chargerType, StationChargingPoints chargingPoints,
                      StationStatus status) {

}
