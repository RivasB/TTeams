package cloud.tteams.identity.organization.application.command.update;

import java.util.UUID;

import cloud.tteams.identity.organization.domain.AgencyState;

public class UpdateAgencyRequest {

    private UUID id;

    private String name;

    private String description;

    private UUID country;

    private UUID province;

    private UUID canton;

    private UUID parroquia;

    private String region;

    private String latitude;

    private String longitude;

    private AgencyState state;

    public UpdateAgencyRequest() {
    }

    public UpdateAgencyRequest(UUID id, String name, String description, UUID country, UUID province, UUID canton,
            UUID parroquia, String region, String latitude, String longitude, AgencyState state) {
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

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCountry() {
        return country;
    }

    public UUID getProvince() {
        return province;
    }

    public UUID getCanton() {
        return canton;
    }

    public UUID getParroquia() {
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
