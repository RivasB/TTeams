package cloud.tteams.station.location.domain;

public record Location(LocationId id, LocationAddress address, LocationLatitude latitude, LocationLongitude longitude) {
}
