package ec.gob.registrocivil.identity.agency.application.query;

import java.util.UUID;

import ec.gob.registrocivil.identity.agency.domain.Agency;
import ec.gob.registrocivil.identity.agency.domain.AgencyState;
import ec.gob.registrocivil.identity.geographiclocation.application.GeographicLocationResponse;

public class AgencyResponse {

    private UUID id;

    private String name;

    private String description;

    private GeographicLocationResponse country;

    private GeographicLocationResponse province;

    private GeographicLocationResponse canton;

    private GeographicLocationResponse parroquia;

    private String region;

    private String latitude;

    private String longitude;

    private AgencyState state;

    public AgencyResponse(Agency response) {
        this.id = response.getId().getValue();
        this.name = response.getName().getValue();
        this.description = response.getDescription().getValue();
        this.country = new GeographicLocationResponse(response.getCountry());
        this.province = new GeographicLocationResponse(response.getProvince());
        this.canton = new GeographicLocationResponse(response.getCanton());
        this.parroquia = new GeographicLocationResponse(response.getParroquia());
        this.region = response.getRegion().getValue();
        this.state = response.getState();
        this.latitude = response.getLatitute().getValue();
        this.longitude = response.getLongitude().getValue();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public GeographicLocationResponse getCountry() {
        return country;
    }

    public GeographicLocationResponse getProvince() {
        return province;
    }

    public GeographicLocationResponse getCanton() {
        return canton;
    }

    public GeographicLocationResponse getParroquia() {
        return parroquia;
    }

    public String getRegion() {
        return region;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public AgencyState getState() {
        return state;
    }

}
