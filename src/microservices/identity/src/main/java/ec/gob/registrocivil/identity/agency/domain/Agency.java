package ec.gob.registrocivil.identity.agency.domain;

import ec.gob.registrocivil.identity.geographiclocation.domain.GeographicLocation;

public final class Agency {

    private AgencyId id;
    private AgencyName name;
    private AgencyDescription description;
    private GeographicLocation country;
    private GeographicLocation province;
    private GeographicLocation canton;
    private GeographicLocation parroquia;
    private AgencyRegion region;
    private AgencyState state;
    private AgencyLatitude latitute;
    private AgencyLongitude longitude;

    public Agency(AgencyId id, AgencyName name, AgencyDescription description, GeographicLocation country,
            GeographicLocation province, GeographicLocation canton, GeographicLocation parroquia,
            AgencyRegion region, AgencyState state, AgencyLatitude latitute,
            AgencyLongitude longitude) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.province = province;
        this.canton = canton;
        this.parroquia = parroquia;
        this.region = region;
        this.state = state;
        this.latitute = latitute;
        this.longitude = longitude;
    }

    public AgencyId getId() {
        return id;
    }

    public AgencyName getName() {
        return name;
    }

    public AgencyDescription getDescription() {
        return description;
    }

    public GeographicLocation getCountry() {
        return country;
    }

    public GeographicLocation getProvince() {
        return province;
    }

    public GeographicLocation getCanton() {
        return canton;
    }

    public GeographicLocation getParroquia() {
        return parroquia;
    }

    public AgencyRegion getRegion() {
        return region;
    }

    public AgencyState getState() {
        return state;
    }

    public AgencyLatitude getLatitute() {
        return latitute;
    }

    public AgencyLongitude getLongitude() {
        return longitude;
    }

}
