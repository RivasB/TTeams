package cloud.tteams.station.location.infrastructure.repository.hibernate;

import cloud.tteams.station.location.domain.*;
import cloud.tteams.station.station.infrastructure.repository.hibernate.StationDto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ev_location")
public class LocationDto {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "address")
    private String address;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @OneToOne(mappedBy = "location")
    private StationDto station;

    public LocationDto() {
    }

    public LocationDto(Location location){
        this.id = location.id().getValue();
        this.address = location.address().getValue();
        this.latitude = location.latitude().getValue();
        this.longitude = location.longitude().getValue();
    }

    public Location toAggregate(){
        LocationId id = new LocationId(this.id);
        LocationAddress address = new LocationAddress(this.address);
        LocationLatitude latitude = new LocationLatitude(this.latitude);
        LocationLongitude longitude = new LocationLongitude(this.longitude);
        return new Location(id,address,latitude,longitude);
    }

    public UUID getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public StationDto getStation() {
        return station;
    }
}
