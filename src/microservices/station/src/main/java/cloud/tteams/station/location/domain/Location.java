package cloud.tteams.station.location.domain;

import cloud.tteams.station.station.domain.Station;

public class
Location{
    private LocationId id;
    private LocationAddress address;
    private LocationLatitude latitude;
    private LocationLongitude longitude;
    private Station station;

    public Location(LocationId id, LocationAddress address, LocationLatitude latitude,
                    LocationLongitude longitude, Station station) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.station = station;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", address=" + address +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", station=" + station +
                '}';
    }

    public LocationId getId() {
        return id;
    }

    public LocationAddress getAddress() {
        return address;
    }

    public LocationLatitude getLatitude() {
        return latitude;
    }

    public LocationLongitude getLongitude() {
        return longitude;
    }

    public Station getStation() {
        return station;
    }
}
