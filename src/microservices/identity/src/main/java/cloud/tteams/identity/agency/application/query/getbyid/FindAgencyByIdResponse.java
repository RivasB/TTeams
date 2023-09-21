package cloud.tteams.identity.agency.application.query.getbyid;

import java.util.UUID;

import cloud.tteams.identity.agency.domain.Agency;
import cloud.tteams.identity.agency.domain.AgencyState;
import cloud.tteams.identity.geographiclocation.application.GeographicLocationResponse;
import cloud.tteams.share.core.domain.bus.query.IResponse;

public class FindAgencyByIdResponse implements IResponse {

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

    public FindAgencyByIdResponse(
            UUID id,
            String name,
            String description,
            GeographicLocationResponse country,
            GeographicLocationResponse province,
            GeographicLocationResponse canton,
            GeographicLocationResponse parroquia,
            String region,
            String latitude,
            String longitude,
            AgencyState state) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.province = province;
        this.canton = canton;
        this.parroquia = parroquia;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }

    public FindAgencyByIdResponse(Agency agency) {
        this.id = agency.getId().value();
        this.name = agency.getName().value();
        this.description = agency.getDescription().value();
        this.country = new GeographicLocationResponse(agency.getCountry());
        this.province = new GeographicLocationResponse(agency.getProvince());
        this.canton = new GeographicLocationResponse(agency.getCanton());
        this.parroquia = new GeographicLocationResponse(agency.getParroquia());
        this.region = agency.getRegion().value();
        this.latitude = agency.getLatitute().value();
        this.longitude = agency.getLongitude().value();
        this.state = agency.getState();
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
