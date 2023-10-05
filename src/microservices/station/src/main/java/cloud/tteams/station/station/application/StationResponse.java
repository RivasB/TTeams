package cloud.tteams.station.station.application;


import cloud.tteams.share.core.domain.bus.query.IResponse;
import cloud.tteams.station.chargingpoint.application.ChargingPointResponse;
import cloud.tteams.station.location.application.LocationResponse;
import cloud.tteams.station.station.domain.Station;
import cloud.tteams.station.station.domain.StationChargerType;
import cloud.tteams.station.station.domain.StationStatus;

import java.util.Collection;
import java.util.UUID;

public class StationResponse implements IResponse {

    private final UUID id;
    private final LocationResponse location;
    private final StationChargerType chargerType;
    private final Collection<ChargingPointResponse> chargingPoints;
    private final StationStatus status;

    public StationResponse(UUID id, LocationResponse location, StationChargerType chargerType,
                           Collection<ChargingPointResponse> chargingPoints, StationStatus status) {
        this.id = id;
        this.location = location;
        this.chargerType = chargerType;
        this.chargingPoints = chargingPoints;
        this.status = status;
    }

    public StationResponse(Station station){
        this.id = station.getId().getValue();
        this.location = new LocationResponse(station.getLocation());
        this.chargerType = station.getChargerType();
        this.chargingPoints = station.getChargingPoints()
                .getValue().stream().map(ChargingPointResponse::new).toList();
        this.status = station.getStatus();

    }

    public UUID getId() {
        return id;
    }

    public LocationResponse getLocation() {
        return location;
    }

    public StationChargerType getChargerType() {
        return chargerType;
    }

    public Collection<ChargingPointResponse> getChargingPoints() {
        return chargingPoints;
    }

    public StationStatus getStatus() {
        return status;
    }
}
